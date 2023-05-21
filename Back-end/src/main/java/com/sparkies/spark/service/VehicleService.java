package com.sparkies.spark.service;


import java.util.Optional;

import com.sparkies.spark.model.AppUser;
import com.sparkies.spark.model.Energy;
import com.sparkies.spark.model.TypeVehicle;
import com.sparkies.spark.model.Profile;
import com.sparkies.spark.model.Vehicle;

public interface VehicleService {

	public void addVehiculeByUser(Vehicle vehicle, TypeVehicle typeVehicle, Energy energy, AppUser user);

	public Optional<Vehicle> getOneVehicule(final Long id);

	public Iterable<Vehicle> getAllVehicules();

	public void deleteVehicle(final Long id);
	
	public Vehicle saveVehicle(Vehicle vehicule);

}
