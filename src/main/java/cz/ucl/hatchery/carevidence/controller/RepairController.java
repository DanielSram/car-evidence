package cz.ucl.hatchery.carevidence.controller;

import cz.ucl.hatchery.carevidence.facade.RepairFacade;
import cz.ucl.hatchery.carevidence.model.RepairDTO;
import cz.ucl.hatchery.carevidence.model.RepairNewForm;
import cz.ucl.hatchery.carevidence.web.CommonConstants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping(value = RepairController.BASE_URL, produces = MediaType.APPLICATION_JSON_VALUE)
public class RepairController {

    public final static String BASE_URL = CommonConstants.SLASH + "repairs";

    @Autowired
    private RepairFacade repairFacade;

    /**
     * Creates new Repair
     * @param form
     *          containing form data
     */
    @RequestMapping(method = RequestMethod.POST)
    public void createRepair(@RequestBody RepairNewForm form) {
        repairFacade.createRepair(form);
    }

    /**
     * Fetches repairs for car with given Id
     * @param id
     *          of car
     * @return
     *          array of RepairDTO
     */
    @RequestMapping(value = "/forCar/{id}", method = RequestMethod.GET)
    public RepairDTO[] getRevisionsForCar(@PathVariable Long id) {
        final List<RepairDTO> result = repairFacade.getRepairsForCar(id);
        return result.toArray(new RepairDTO[result.size()]);
    }

}
