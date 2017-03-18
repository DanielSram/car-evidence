package cz.ucl.hatchery.carevidence.controller;

import cz.ucl.hatchery.carevidence.facade.CreateLendingFacade;
import cz.ucl.hatchery.carevidence.model.LendingDTO;
import cz.ucl.hatchery.carevidence.model.LendingNewForm;
import cz.ucl.hatchery.carevidence.service.LendingManagerService;
import cz.ucl.hatchery.carevidence.web.CommonConstants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping(value = LendingController.BASE_URL, produces = MediaType.APPLICATION_JSON_VALUE)
public class LendingController {

    public final static String BASE_URL = CommonConstants.SLASH + "lendings";

    @Autowired
    private CreateLendingFacade createLendingFacade;

    @Autowired
    private LendingManagerService lendingService;

    /**
     * Creates new Lending
     *
     * @param lendingForm
     */
    @RequestMapping(method = RequestMethod.POST)
    public void createLending(@RequestBody LendingNewForm lendingForm) {
        createLendingFacade.createLending(lendingForm);
    }

    /**
     * Finds lending with given id
     * @param id
     * @return
     */
    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public LendingDTO getLendingById(@PathVariable Long id) {
        return id == null ? null : lendingService.getLendingById(id);
    }

}
