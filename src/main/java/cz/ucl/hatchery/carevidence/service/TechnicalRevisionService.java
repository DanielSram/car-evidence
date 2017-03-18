package cz.ucl.hatchery.carevidence.service;

import cz.ucl.hatchery.carevidence.entity.Car;
import cz.ucl.hatchery.carevidence.model.NewTechnicalRevisionForm;
import cz.ucl.hatchery.carevidence.model.TechnicalRevisionDTO;

import java.util.List;

/**
 * Service interface for Technical Revision entities
 */
public interface TechnicalRevisionService {

    /**
     * Creates new Technical Revision
     * @param form
     *          containing data of new revision
     * @param car
     *          that was revised
     */
    public void createTechnicalRevision(NewTechnicalRevisionForm form, Car car);

    /**
     * Fetches all Technical Revisions for given car ID.
     * @param carId
     *          id of car to list revisions for
     * @return List of TechnicalRevisionDTO
     */
    public List<TechnicalRevisionDTO> getRevisionsForCar(Long carId);

}
