package cz.ucl.hatchery.carevidence.service;

import cz.ucl.hatchery.carevidence.dao.LendingDAO;
import cz.ucl.hatchery.carevidence.entity.Car;
import cz.ucl.hatchery.carevidence.entity.Lending;
import cz.ucl.hatchery.carevidence.entity.client.Client;
import cz.ucl.hatchery.carevidence.model.LendingDTO;
import cz.ucl.hatchery.carevidence.model.LendingNewForm;
import cz.ucl.hatchery.carevidence.util.DTOConverter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Lending Service implementation
 */
@Service
@Transactional
public class LendingManagerServiceBean implements LendingManagerService {

    @Autowired
    private LendingDAO lendingDAO;

    public void createLending(LendingNewForm lendingForm) {
        final Lending lending = new Lending();
        setFieldsFromDTO(lendingForm, lending);
        lendingDAO.save(lending);
    }

    public void createLending(LendingNewForm lendingForm, Car car, Client client) {
        final Lending lending = new Lending();

        lending.setCar(car);
        lending.setClient(client);
        setFieldsFromDTO(lendingForm, lending);

        lendingDAO.save(lending);
    }

    private void setFieldsFromDTO(LendingNewForm lendingForm, Lending lending) {
        lending.setId(lendingForm.getId());
        lending.setPrice(lendingForm.getPrice());
        lending.setDateFrom(lendingForm.getDateFrom());
        lending.setDateTo(lendingForm.getDateTo());
        lending.setLatitude(lendingForm.getLatitude());
        lending.setLongitude(lendingForm.getLongitude());
    }

    public LendingDTO getLendingById(Long id) {
        return DTOConverter.convert(lendingDAO.findById(id));
    }
}
