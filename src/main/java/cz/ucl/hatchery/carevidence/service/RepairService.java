package cz.ucl.hatchery.carevidence.service;

import cz.ucl.hatchery.carevidence.entity.Car;
import cz.ucl.hatchery.carevidence.model.RepairDTO;
import cz.ucl.hatchery.carevidence.model.RepairNewForm;

import java.util.List;

/**
 * Service class for managing Repair entities
 */
public interface RepairService {

    /**
     * Creates new Repair
     * @param form
     *          containing data of new repair
     * @param car
     *          that was repaired
     */
    public void createRepair(RepairNewForm form, Car car);

    /**
     * Fetches all repairs for given car ID.
     * @param carId
     *          id of car to list repairs for
     * @return List of RepairDTO
     */
    public List<RepairDTO> getRepairsForCar(Long carId);

}
