package cz.ucl.hatchery.carevidence.facade;

import cz.ucl.hatchery.carevidence.model.RepairDTO;
import cz.ucl.hatchery.carevidence.model.RepairNewForm;

import java.util.List;

public interface RepairFacade {

    /**
     * Creates new Repair
     * @param form
     *          containing data of repair
     */
    public void createRepair(RepairNewForm form);

    /**
     * Fetches technical revisions for car with given Id
     * @param id
     *          of car
     * @return
     *          List of TechnicalRevisionDTO
     */
    public List<RepairDTO> getRepairsForCar(Long id);

}
