package com.sparkies.spark.controller.rest;



import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sparkies.spark.exception.ErrorVehicle;
import com.sparkies.spark.model.Energy;
import com.sparkies.spark.model.TypeVehicle;
import com.sparkies.spark.model.Vehicle;

import com.sparkies.spark.repository.EnergyRepo;
import com.sparkies.spark.repository.AppUserRepo;
import com.sparkies.spark.repository.VehicleRepo;
import com.sparkies.spark.service.VehicleService;
import com.sparkies.spark.service.impl.VehicleServiceImpl;

@RestController
@RequestMapping("api/vehicle")
@CrossOrigin(origins = "http://localhost:4200")
public class VehicleControllerRest {

	@Autowired
	VehicleRepo vehicleRepo;


	private String message;

	/**
	 * Check in the DB if the vehicule exists
	 * @param vid -> id of vehicle
	 * @throws ErrorVehicle
	 */
	private void checkVehicle(Long vid) throws ErrorVehicle {

		if (vehicleRepo.findById(vid).isEmpty()) {
			throw new ErrorVehicle("N° du vehicule " + vid + " non trouvé");
		}
	}

	/**
	 * Create a vehicle and save in DB
	 * 
	 * @param vehicule
	 * @return
	 */
	@PostMapping
	public Vehicle create(@Validated @RequestBody Vehicle vehicle, BindingResult result) throws ErrorVehicle {

		if (result.hasErrors()) {
			message = "";
			result.getFieldErrors().forEach(e -> {
				message += e.getField() + "-" + e.getDefaultMessage();
			});

			throw new ErrorVehicle(message);
		}
		return vehicleRepo.save(vehicle);
	}
	

	/**
	 * Get all vehicle from DB
	 * 
	 * @return list of vehicle
	 */
	@GetMapping
	public Iterable<Vehicle> getAll() {
		return vehicleRepo.findAll();
	}

	/**
	 * Get one vehicle by id
	 * 
	 * @param vid -> id of vehicle
	 * @return vehicle found
	 * @throws ErrorVehicle
	 */
	@GetMapping("{id}")
	public Optional<Vehicle> getOne(@PathVariable("id") Long vid) throws ErrorVehicle {
		checkVehicle(vid);
		return vehicleRepo.findById(vid);
	}

	/**
	 * Update a vehicule
	 * 
	 * @param vehicle
	 * @return
	 * @throws ErrorVehicle
	 */
	@PutMapping("{id}")
	public Vehicle update(@RequestBody Vehicle vehicle, @PathVariable("id") Long vid) throws ErrorVehicle {

		checkVehicle(vid);
		if (vid != vehicle.getIdVehicle()) {
			throw new ErrorVehicle("N°  du vehicule " + vid + " passé en variable est different du contenu JSON : "
					+ vehicle.getIdVehicle());
		}
		
		return vehicleRepo.save(vehicle);
	}

	/**
	 * Delete a vehicle
	 * 
	 * @param vid
	 * @throws ErrorVehicle
	 */
	@DeleteMapping("{id}")
	public void delete(@PathVariable("id") Long vid) throws ErrorVehicle {
		checkVehicle(vid);
		vehicleRepo.deleteById(vid);

	}

}
