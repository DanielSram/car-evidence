/**
 * 
 */
package cz.ucl.hatchery.carevidence.service;

import java.util.List;

import cz.ucl.hatchery.carevidence.entity.Car;
import cz.ucl.hatchery.carevidence.model.*;

/**
 * @author DZCJS9F
 *
 */
public interface CarManagerService {

	/**
	 * Creates new Car
	 * @param carNewForm
	 * 				containing form data
	 */
	public void createNewCar(CarNewForm carNewForm);

	public List<CarDTO> getAllCars();

	public List<CarDTO> findCarsByFilter(CarFilter filter);

	public CarDTO getCarById(Long id);

	public void update(CarDTO car);

	public Car getEntity(Long id);

	/**
	 * Finds cars of given type available for lending at given time
	 * @param filter
	 * 				containing form data
	 * @return list of CarDTO objects
	 */
	public List<CarDTO> findAvailable(AvailableCarFilter filter);

	/**
	 * Fetches cars with upcoming or unknown technical revisions
	 * @return list of CarNeedingRevisionDTO objects
	 */
	public List<CarNeedingRevisionDTO> getCarsWithForthcomingRevisions();

}
