package cz.ucl.hatchery.carevidence.facade;

import cz.ucl.hatchery.carevidence.entity.Car;
import cz.ucl.hatchery.carevidence.model.RepairDTO;
import cz.ucl.hatchery.carevidence.model.RepairNewForm;
import cz.ucl.hatchery.carevidence.service.CarManagerService;
import cz.ucl.hatchery.carevidence.service.RepairService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class RepairFacadeBean implements RepairFacade {

    @Autowired
    private CarManagerService carService;

    @Autowired
    private RepairService repairService;

    public void createRepair(RepairNewForm form) {
        Car car = carService.getEntity(form.getCar());
        repairService.createRepair(form, car);
    }

    public List<RepairDTO> getRepairsForCar(Long id) {
        return repairService.getRepairsForCar(id);
    }

}
