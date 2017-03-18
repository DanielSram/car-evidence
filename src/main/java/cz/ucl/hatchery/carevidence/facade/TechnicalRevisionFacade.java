package cz.ucl.hatchery.carevidence.facade;

import cz.ucl.hatchery.carevidence.model.NewTechnicalRevisionForm;
import cz.ucl.hatchery.carevidence.model.TechnicalRevisionDTO;

import java.util.List;

/**
 * Facade class for managing Technical Revisions
 */
public interface TechnicalRevisionFacade {

    /**
     * Creates new Technical Revision
     * @param form
     *          containing data of revision
     */
    public void createTechnicalRevision(NewTechnicalRevisionForm form);

    /**
     * Fetches technical revisions for car with given Id
     * @param id
     *          of car
     * @return
     *          List of TechnicalRevisionDTO
     */
    public List<TechnicalRevisionDTO> getRevisionsForCar(Long id);

}
