package cz.ucl.hatchery.carevidence.facade;

import cz.ucl.hatchery.carevidence.entity.Car;
import cz.ucl.hatchery.carevidence.model.NewTechnicalRevisionForm;
import cz.ucl.hatchery.carevidence.model.TechnicalRevisionDTO;
import cz.ucl.hatchery.carevidence.service.CarManagerService;
import cz.ucl.hatchery.carevidence.service.TechnicalRevisionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class TechnicalRevisionFacadeBean implements TechnicalRevisionFacade {

    @Autowired
    private CarManagerService carService;

    @Autowired
    private TechnicalRevisionService technicalRevisionService;

    /**
     * Creates new Technical Revision
     * @param form
     *          containing data of revision
     */
    public void createTechnicalRevision(NewTechnicalRevisionForm form) {
        Car car = carService.getEntity(form.getCar());
        technicalRevisionService.createTechnicalRevision(form, car);
    }

    /**
     * Fetches technical revisions for car with given Id
     * @param id
     *          of car
     * @return
     *          List of TechnicalRevisionDTO
     */
    public List<TechnicalRevisionDTO> getRevisionsForCar(Long id) {
        return technicalRevisionService.getRevisionsForCar(id);
    }

}

