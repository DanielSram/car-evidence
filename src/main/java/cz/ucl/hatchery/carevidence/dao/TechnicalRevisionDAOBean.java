package cz.ucl.hatchery.carevidence.dao;

import cz.ucl.hatchery.carevidence.entity.TechnicalRevision;
import org.hibernate.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class TechnicalRevisionDAOBean
        extends GenericHibernateDAO<TechnicalRevision, Long>
        implements TechnicalRevisionDAO {

    /**
     * Fetches all Technical Revisions for given car ID.
     * @param carId
     *          id of car to fetch revisions for
     * @return List of TechnicalRevisionDTO
     */
    public List<TechnicalRevision> getRevisionsForCar(Long carId) {
        Query query = getSession().getNamedQuery(TechnicalRevision.REVISIONS_FOR_CAR_QUERY_NAME)
                .setParameter("carId", carId);
        return query.list();
    }

}
