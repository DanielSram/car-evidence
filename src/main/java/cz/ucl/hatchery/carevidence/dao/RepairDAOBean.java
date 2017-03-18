package cz.ucl.hatchery.carevidence.dao;

import cz.ucl.hatchery.carevidence.entity.Repair;
import org.hibernate.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class RepairDAOBean extends GenericHibernateDAO<Repair, Long> implements RepairDAO {

    /**
     * Fetches all Repairs for given car ID.
     * @param carId
     *          id of car to fetch repairs for
     * @return List of RepairDTO
     */
    public List<Repair> getRepairsForCar(Long carId) {
        Query query = getSession().getNamedQuery(Repair.REPAIRS_FOR_CAR_QUERY_NAME)
                .setParameter("carId", carId);
        return query.list();
    }
}
