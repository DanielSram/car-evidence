package cz.ucl.hatchery.carevidence.dao;

import cz.ucl.hatchery.carevidence.entity.Repair;

import java.util.List;

/**
 * Interface for managing Technical Revision data access objects
 */
public interface RepairDAO extends GenericDAO<Repair, Long> {

    /**
     * Fetches all Repairs for given car ID.
     * @param carId
     *          id of car to fetch repairs for
     * @return List of RepairDTO
     */
    public List<Repair> getRepairsForCar(Long carId);

}
