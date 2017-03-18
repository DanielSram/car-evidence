package cz.ucl.hatchery.carevidence.controller;

import cz.ucl.hatchery.carevidence.model.CarDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.http.MediaType;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import cz.ucl.hatchery.carevidence.model.CarNewForm;
import cz.ucl.hatchery.carevidence.service.CarManagerService;
import cz.ucl.hatchery.carevidence.web.CommonConstants;
import cz.ucl.hatchery.carevidence.web.ControllerUtils;
import cz.ucl.hatchery.carevidence.web.RequestParamsConstants;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping(value = CarController.BASE_URL, produces = MediaType.APPLICATION_JSON_VALUE)
public class CarController {

    public static final String BASE_URL = CommonConstants.SLASH + "cars";

    @Autowired
    private CarManagerService carManagerService;

    /**
     * Updates existing car
     * if car is not found, throws RuntimeException
     * @throws RuntimeException
     * @param car
     */
    @RequestMapping(method = RequestMethod.PUT)
    public void updateCar(@RequestBody final CarDTO car) throws RuntimeException {
        carManagerService.update(car);
    }


}
