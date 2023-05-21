package com.sparkies.spark.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sparkies.spark.model.Energy;
import com.sparkies.spark.model.Vehicle;
import com.sparkies.spark.model.Zone;
import com.sparkies.spark.repository.AppUserRepo;

import com.sparkies.spark.repository.ZoneRepo;
import com.sparkies.spark.service.EmissionService;

@Service
public class EmissionServiceImpl implements EmissionService {

	@Autowired
	ZoneRepo zoneRepo;

	@Autowired
	AppUserRepo userRepo;

	/**
	 * Method to calculate the distance traveled by a user looking for a carpark
	 * 
	 */
	@Override
	public double distanceLookForPark(Zone zone) {

		double time = Math.ceil((zone.getMinute() / 60) + 1); // result in hour
		double speed = 20;
		return speed * time;
	}

	/**
	 * Method to calculate footprint carbon by consomation of the user's car (custom
	 * values footprint carbon)
	 */
	// if the vehicle'energy of client is "Diesel or Essence"
	@Override
	public double carbonFootprintByConso(Vehicle vehicle) {

		double consomation = vehicle.getConsomation();
		Energy energy = vehicle.getEnergy();
		double coefficient = energy.getCoefficient();
		return Math.ceil(consomation * coefficient / 100);
	}

	/**
	 * Method to calculate the carbon emission when a user looking for a carpark
	 * (with custom values footprint carbon)
	 */
	@Override
	public double emissionConsumedByRoutePerso(int distanceKmDone, double carbonFootprint) {

		return carbonFootprint * distanceKmDone;
	}

	/**
	 * Method to calculate the carbon emission when a user looking for a carpark
	 * (with standard value footprint carbon)
	 */
	@Override
	public double emissionConsumedByRoute(int distanceKmDone, Vehicle vehicle) {

		Energy energy = vehicle.getEnergy();
		return energy.getCoefficient() * distanceKmDone;
	}

}
