package cz.ucl.hatchery.carevidence.controller;

import cz.ucl.hatchery.carevidence.facade.TechnicalRevisionFacade;
import cz.ucl.hatchery.carevidence.model.NewTechnicalRevisionForm;
import cz.ucl.hatchery.carevidence.model.TechnicalRevisionDTO;
import cz.ucl.hatchery.carevidence.web.CommonConstants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping(value = TechnicalRevisionController.BASE_URL, produces = MediaType.APPLICATION_JSON_VALUE)
public class TechnicalRevisionController {

    public final static String BASE_URL = CommonConstants.SLASH + "revisions";

    @Autowired
    private TechnicalRevisionFacade technicalRevisionFacade;

    /**
     * Creates new Technical Revision
     * @param form
     *          containing form data
     */
    @RequestMapping(method = RequestMethod.POST)
    public void createTechnicalRevision(@RequestBody NewTechnicalRevisionForm form) {
        technicalRevisionFacade.createTechnicalRevision(form);
    }

    /**
     * Fetches technical revisions for car with given Id
     * @param id
     *          of car
     * @return
     *          array of TechnicalRevisionDTO
     */
    @RequestMapping(value = "/forCar/{id}", method = RequestMethod.GET)
    public TechnicalRevisionDTO[] getRevisionsForCar(@PathVariable Long id) {
        final List<TechnicalRevisionDTO> result = technicalRevisionFacade.getRevisionsForCar(id);
        return result.toArray(new TechnicalRevisionDTO[result.size()]);
    }

}
