package cz.ucl.hatchery.carevidence.service;

import cz.ucl.hatchery.carevidence.entity.Car;
import cz.ucl.hatchery.carevidence.entity.client.Client;
import cz.ucl.hatchery.carevidence.model.LendingDTO;
import cz.ucl.hatchery.carevidence.model.LendingNewForm;

/**
 * Service interface for Lending entities
 */
public interface LendingManagerService {

    /**
     * Creates new Lending entity
     * @param lendingForm
     *              containing data of new Lending
     */
    public void createLending(LendingNewForm lendingForm, Car car, Client client);

    /**
     * Find lending by given id
     * @param id
     * @return
     */
    public LendingDTO getLendingById(Long id);

}
