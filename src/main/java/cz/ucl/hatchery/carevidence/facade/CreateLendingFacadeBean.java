package cz.ucl.hatchery.carevidence.facade;

import cz.ucl.hatchery.carevidence.entity.Car;
import cz.ucl.hatchery.carevidence.entity.client.Client;
import cz.ucl.hatchery.carevidence.model.LendingNewForm;
import cz.ucl.hatchery.carevidence.service.CarManagerService;
import cz.ucl.hatchery.carevidence.service.ClientService;
import cz.ucl.hatchery.carevidence.service.LendingManagerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class CreateLendingFacadeBean implements CreateLendingFacade {

    @Autowired
    private LendingManagerService lendingManagerService;

    @Autowired
    private CarManagerService carService;

    @Autowired
    private ClientService clientService;

    public void createLending(LendingNewForm lendingForm) {

        Car car = carService.getEntity(lendingForm.getCar());
        Client client = clientService.getEntity(lendingForm.getClient());

        lendingManagerService.createLending(lendingForm, car, client);
    }

}
