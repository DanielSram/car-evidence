package cz.ucl.hatchery.carevidence.dao;

import cz.ucl.hatchery.carevidence.entity.TechnicalRevision;
import cz.ucl.hatchery.carevidence.model.TechnicalRevisionDTO;

import java.util.List;

/**
 * Interface for managing Technical Revision data access objects
 */
public interface TechnicalRevisionDAO extends GenericDAO<TechnicalRevision, Long> {

    /**
     * Fetches all Technical Revisions for given car ID.
     * @param carId
     *          id of car to fetch revisions for
     * @return List of TechnicalRevisionDTO
     */
    public List<TechnicalRevision> getRevisionsForCar(Long carId);

}
