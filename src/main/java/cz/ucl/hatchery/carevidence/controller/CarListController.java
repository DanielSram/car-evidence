/**
 * 
 */
package cz.ucl.hatchery.carevidence.controller;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import cz.ucl.hatchery.carevidence.model.AvailableCarFilter;
import cz.ucl.hatchery.carevidence.model.CarNeedingRevisionDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.http.MediaType;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

import cz.ucl.hatchery.carevidence.model.CarDTO;
import cz.ucl.hatchery.carevidence.model.CarFilter;
import cz.ucl.hatchery.carevidence.service.CarManagerService;
import cz.ucl.hatchery.carevidence.web.CommonConstants;

/**
 * @author DZCJS9F
 *
 */
@CrossOrigin(origins = "*")
@RestController
@RequestMapping(value = CarListController.BASE_URL, produces = MediaType.APPLICATION_JSON_VALUE)
public class CarListController {

	public static final String BASE_URL = CommonConstants.SLASH + "cars";

	@Autowired
	private CarManagerService carService;

	@RequestMapping(method = RequestMethod.GET)
	public CarDTO[] getAllCars() {
		final List<CarDTO> cars = carService.getAllCars();

		return cars.toArray(new CarDTO[cars.size()]);
	}

	/**
	 * Retrieves a car based on its id.
	 * @param id Car id.
	 * @return CarDTO or null if not found.
	 */
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public CarDTO getCarById(@PathVariable Long id) {
		return id == null ? null : carService.getCarById(id);
	}

	@RequestMapping(value = "/find", method = RequestMethod.GET)
	// public CarDTO[] findByFilter(@RequestParam(required = false) final Long id,
	// @RequestParam(required = false) final String type,
	// @RequestParam(required = false) final String vin,
	// @RequestParam(required = false) final String state,
	// @RequestParam(required = false) final BigDecimal priceFrom,
	// @RequestParam(required = false) final BigDecimal priceTo,
	// @RequestParam(required = false) final Date acquiredFrom,
	// @RequestParam(required = false) final Date acquiredTo,
	// @RequestParam(required = false) final Date lastTechnicalCheckFrom,
	// @RequestParam(required = false) final Date lastTechnicalCheckTo) {
	public CarDTO[] findByFilter(final CarFilter carFilter) {

		// final CarFilter filter = new CarFilter(id, type, vin, state, priceFrom, priceTo, acquiredFrom, acquiredTo,
		// lastTechnicalCheckFrom, lastTechnicalCheckTo);
		final List<CarDTO> result = carService.findCarsByFilter(carFilter);

		return result.toArray(new CarDTO[result.size()]);
	}

	/**
	 * Finds cars of given type available for lending at given time
	 * @param carFilter
	 * 				containing form data
	 * @return list of CarDTO objects
	 */
	@RequestMapping(value = "/findAvailable", method = RequestMethod.GET)
	public CarDTO[] findAvailableCars(final AvailableCarFilter carFilter) {

		final List<CarDTO> cars = carService.findAvailable(carFilter);
		return cars.toArray(new CarDTO[cars.size()]);
	}

	/**
	 * Fetches cars with upcoming or unknown technical revisions
	 * @return list of CarDTO objects
	 */
	@RequestMapping(value = "/withForthcomingRevision", method = RequestMethod.GET)
	public CarNeedingRevisionDTO[] getCarsWithForthcomingRevisions() {
		final List<CarNeedingRevisionDTO> cars = carService.getCarsWithForthcomingRevisions();
		return cars.toArray(new CarNeedingRevisionDTO[cars.size()]);
	}

	@InitBinder
	public void initBinder(final WebDataBinder binder) {
		final SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		binder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, false));
	}

}
