/**
 *
 */
package cz.ucl.hatchery.carevidence.service;

import java.util.List;

import cz.ucl.hatchery.carevidence.model.*;
import cz.ucl.hatchery.carevidence.util.CarNeedingRevisionDTOConverter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cz.ucl.hatchery.carevidence.dao.CarDAO;
import cz.ucl.hatchery.carevidence.entity.Car;
import cz.ucl.hatchery.carevidence.model.enumeration.CarState;
import cz.ucl.hatchery.carevidence.model.enumeration.CarsType;
import cz.ucl.hatchery.carevidence.util.CoreDateUtil;
import cz.ucl.hatchery.carevidence.util.DTOConverter;

/**
 * @author DZCJS9F
 */
@Service
@Transactional
public class CarManagerServiceBean implements CarManagerService {

    @Autowired
    private CarDAO carDAO;

    public void createNewCar(final CarNewForm carNewForm) {
        final Car car = createGeneralCar();
        setFieldFromDto(carNewForm, car);
        save(car);
    }

    public List<CarNeedingRevisionDTO> getCarsWithForthcomingRevisions() {
        return CarNeedingRevisionDTOConverter.convert(carDAO.getCarsWithForthcomingRevisions());
    }

    public List<CarDTO> findAvailable(AvailableCarFilter filter) {
        return DTOConverter.convert(carDAO.findAvailableCars(filter));
    }

    public void update(CarDTO carDTO) {
        Car car = carDAO.findById(carDTO.getId());

        if (car == null) throw new RuntimeException("Car with given ID not found");

        car.setCarState(CarState.valueOf(carDTO.getCarState()));
        car.setType(CarsType.valueOf(carDTO.getType()));
        car.setDateOfAcquisition(carDTO.getDateOfAcquisition());
        car.setDateOfLastTechnicalCheck(carDTO.getDateOfLastTechnicalCheck());
        car.setPrice(carDTO.getPrice());
        car.setVin(carDTO.getVin());
        carDAO.save(car);
    }

    /**
     * {@inheritDoc}
     */
    public List<CarDTO> getAllCars() {
        return DTOConverter.convert(carDAO.findAll());
    }

    public CarDTO getCarById(Long id) {
        return DTOConverter.convert(carDAO.findById(id));
    }

    public Car getEntity(Long id) {
        return carDAO.findById(id);
    }

    /**
     * {@inheritDoc}
     */
    public List<CarDTO> findCarsByFilter(final CarFilter filter) {

        return DTOConverter.convert(carDAO.findByFilter(filter));
    }

    /**
     * @param carNewForm
     * @param car
     */
    private void setFieldFromDto(final CarNewForm carNewForm, final Car car) {
        car.setPrice(carNewForm.getPrice());
        car.setType(CarsType.valueOf(carNewForm.getType()));
        car.setVin(carNewForm.getVin());
        car.setNickname(carNewForm.getNickname());
        car.setDateOfAcquisition(carNewForm.getDateOfAcquisition());
    }

    /**
     * @param car
     */
    private void save(final Car car) {
        carDAO.save(car);
    }

    /**
     *
     */
    private Car createGeneralCar() {
        final Car car = new Car();
        car.setCarState(CarState.defaultState());
        car.setDateOfAcquisition(CoreDateUtil.getNow());

        return car;
    }

}
