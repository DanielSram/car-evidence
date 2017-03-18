package cz.ucl.hatchery.carevidence.dao;

import java.util.List;

import cz.ucl.hatchery.carevidence.entity.Car;
import cz.ucl.hatchery.carevidence.model.AvailableCarFilter;
import cz.ucl.hatchery.carevidence.model.CarFilter;

/**
 * Interface for managing Car data access objects
 */
public interface CarDAO extends GenericDAO<Car, Long> {

	/**
	 * Fetches Cars by given filter and returns result as a List
	 * @param filter
	 * 			containing form data
	 * @return list of Car objects
	 */
	public List<Car> findByFilter(CarFilter filter);

	/**
	 * Finds cars of given type available for lending at given time
	 * @param filter
	 * 				containing form data
	 * @return list of Car objects
	 */
	public List<Car> findAvailableCars(AvailableCarFilter filter);

	/**
	 * Fetches cars with upcoming or unknown technical revisions
	 * @return list of Car objects
	 */
	public List<Object[]> getCarsWithForthcomingRevisions();

}
