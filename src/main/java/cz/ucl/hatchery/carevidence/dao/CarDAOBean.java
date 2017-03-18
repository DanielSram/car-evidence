package cz.ucl.hatchery.carevidence.dao;

import java.util.Calendar;
import java.util.Date;
import java.util.List;

import cz.ucl.hatchery.carevidence.model.AvailableCarFilter;
import cz.ucl.hatchery.carevidence.model.enumeration.CarState;
import cz.ucl.hatchery.carevidence.util.CoreDateUtil;
import org.hibernate.Query;
import org.springframework.stereotype.Repository;

import cz.ucl.hatchery.carevidence.entity.Car;
import cz.ucl.hatchery.carevidence.model.CarFilter;
import cz.ucl.hatchery.carevidence.util.QueryBuilder;

@Repository
public class CarDAOBean extends GenericHibernateDAO<Car, Long> implements CarDAO {

    /**
     * {@inheritDoc}
     */
    @SuppressWarnings("unchecked")
    public List<Car> findByFilter(final CarFilter filter) {
        final Query query = createQueryFromCarFilter(filter);

        return query.list();
    }

    /**
     * Fetches cars with upcoming or unknown technical revisions
     * @return list of Car objects
     */
    public List<Object[]> getCarsWithForthcomingRevisions() {
        Date dayBeforeTenMonths = CoreDateUtil.getDateFromNow(-10, Calendar.MONTH);

        Query query = getSession().getNamedQuery(Car.CARS_WITH_FORTHCOMING_REVISION_QUERY_NAME)
                .setParameter("dayBeforeTenMonths", dayBeforeTenMonths)
                .setParameter("newCarState", CarState.NEW)
                .setParameter("disabledCarState", CarState.DISABLED);

        return query.list();
    }

    /**
     * Finds cars of given type available for lending at given time.
     *
     * @param filter containing availableFrom, availableTo and carType
     * @return list of Car entities
     */
    public List<Car> findAvailableCars(AvailableCarFilter filter) {
        Query query = getSession().getNamedQuery(Car.AVAILABLE_CARS_QUERY_NAME)
                .setParameter("carState", CarState.IN_GARAGE)
                .setParameter("carType", filter.getType())
                .setParameter("newLendingDateFrom", filter.getAvailableFrom())
                .setParameter("newLendingDateTo", filter.getAvailableTo());

        return query.list();
    }

    private Query createQueryFromCarFilter(final CarFilter filter) {
        final QueryBuilder builder = new QueryBuilder(getSession(), "SELECT c FROM Car c WHERE 1 = 1");

        builder.appendIfNotNull("AND c.id = :id", "id", filter.getId());
        builder.appendIfNotNull("AND c.vin = :vin", "vin", filter.getVin());
        builder.appendIfNotNull("AND c.type = :type", "type", filter.getType());
        builder.appendIfNotNull("AND c.state = :state", "state", filter.getState());
        builder.appendIfNotNull("AND c.dateOfAcquisition >= :acquiredFrom", "acquiredFrom", filter.getAcquiredFrom());
        builder.appendIfNotNull("AND c.dateOfAcquisition <= :acquiredTo", "acquiredTo", filter.getAcquiredTo());
        builder.appendIfNotNull("AND c.dateOfLastTechnicalCheck >= :checkFrom", "checkFrom",
                filter.getLastTechnicalCheckFrom());
        builder.appendIfNotNull("AND c.dateOfLastTechnicalCheck <= :checkTo", "checkTo",
                filter.getLastTechnicalCheckTo());
        builder.appendIfNotNull("AND c.price >= :priceFrom", "priceFrom", filter.getPriceFrom());
        builder.appendIfNotNull("AND c.price <= :priceTo", "priceTo", filter.getPriceTo());

        return builder.build();
    }

}
