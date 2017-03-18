package cz.ucl.hatchery.carevidence.facade;

import cz.ucl.hatchery.carevidence.model.LendingNewForm;

/**
 * Facade class for creating Lending
 */
public interface CreateLendingFacade {

    /**
     * Creates new Lending entity
     * @param lendingForm
     *          containing data of lending
     */
    public void createLending(LendingNewForm lendingForm);

}
