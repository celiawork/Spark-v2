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

import com.sparkies.spark.exception.ErrorEnergy;
import com.sparkies.spark.model.Energy;
import com.sparkies.spark.repository.EnergyRepo;


@RestController
@RequestMapping("api/energy")
@CrossOrigin(origins = "http://localhost:4200")
public class EnergyControllerRest {

	@Autowired
	EnergyRepo energyRepo;

	private String message;

	/**
	 * Check in the DB if the energy exists
	 * 
	 * @param eid -> id of energy
	 * @throws ErrorEnergy
	 */
	private void checkEnergy(Long eid) throws ErrorEnergy {

		if (energyRepo.findById(eid).isEmpty()) {
			throw new ErrorEnergy("N° de le l'energie " + eid + " non trouvé");
		}
	}

	/**
	 * Create a energy and save in DB
	 * 
	 * @param energy
	 * @return the number of records
	 */
	@PostMapping
	public Energy create(@Validated @RequestBody Energy energy, BindingResult result) throws ErrorEnergy {

		if (result.hasErrors()) {
			message = "";
			result.getFieldErrors().forEach(e -> {
				message += e.getField() + "-" + e.getDefaultMessage();
			});

			throw new ErrorEnergy(message);
		}
		return energyRepo.save(energy);
	}

	/**
	 * Get all energies from DB
	 * 
	 * @return list of energies
	 */
	@GetMapping
	public Iterable<Energy> getAll() {
		return energyRepo.findAll();
	}

	/**
	 * Get one energy by id
	 * 
	 * @param eid -> eid of energy
	 * @return energy found
	 * @throws ErrorEnergy
	 */
	@GetMapping("{id}")
	public Optional<Energy> getOne(@PathVariable("id") Long eid) throws ErrorEnergy {
		checkEnergy(eid);
		return energyRepo.findById(eid);
	}

	/**
	 * Update a energy
	 * 
	 * @param energy
	 * @return the number of records
	 * @throws ErrorEnergy
	 */
	@PutMapping("{id}")
	public Energy update(@RequestBody Energy energy, @PathVariable("id") Long eid) throws ErrorEnergy {

		checkEnergy(eid);
		if (eid != energy.getIdEnergy()) {
			throw new ErrorEnergy("N°  de l'energie " + eid + " passé en variable est different du contenu JSON : "
					+ energy.getIdEnergy());
		}
		
		return energyRepo.save(energy);
	}

	/**
	 * Delete a energy
	 * 
	 * @param eid
	 * @throws ErrorEnergy
	 */
	@DeleteMapping("{id}")
	public void delete(@PathVariable("id") Long eid) throws ErrorEnergy {
		checkEnergy(eid);
		energyRepo.deleteById(eid);

	}

}
