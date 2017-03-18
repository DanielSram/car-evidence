package cz.ucl.hatchery.carevidence.service;

import cz.ucl.hatchery.carevidence.dao.RepairDAO;
import cz.ucl.hatchery.carevidence.entity.Car;
import cz.ucl.hatchery.carevidence.entity.Repair;
import cz.ucl.hatchery.carevidence.model.RepairDTO;
import cz.ucl.hatchery.carevidence.model.RepairNewForm;
import cz.ucl.hatchery.carevidence.util.DTOConverter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class RepairServiceBean implements RepairService {

    @Autowired
    private RepairDAO repairDAO;

    /**
     * Creates new Repair
     *
     * @param form containing data of new repair
     * @param car  that was repaired
     */
    public void createRepair(RepairNewForm form, Car car) {
        Repair repair = new Repair();
        repair.setCar(car);
        setFieldsFromDTO(form, repair);
        repairDAO.save(repair);
    }

    /**
     * Fetches all repairs for given car ID.
     *
     * @param carId id of car to list repairs for
     * @return List of RepairDTO
     */
    public List<RepairDTO> getRepairsForCar(Long carId) {
       return DTOConverter.convertRepair(repairDAO.getRepairsForCar(carId));
    }

    private void setFieldsFromDTO(RepairNewForm form, Repair repair) {
        repair.setDescription(form.getDescription());
        repair.setPrice(form.getPrice());
    }

}
