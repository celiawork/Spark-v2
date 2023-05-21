package com.sparkies.spark.controller.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import com.sparkies.spark.model.Parking;
import com.sparkies.spark.service.parking.ParkingDisponibilityService;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("api/parking")
public class ParkingControllerRest {
	
	@Autowired
	ParkingDisponibilityService parkingService;
	
	@GetMapping
	public Iterable<Parking>getAll(){
		return parkingService.getAllParking();
	}
	
	@GetMapping("{lat}/{long}/{distMax}")
	public Iterable<Parking>getParkingAround(@PathVariable("lat") Double latitude
			,@PathVariable("long") Double longitude
			,@PathVariable("distMax") Double distMax){

		return parkingService.getParkingList(longitude, latitude, distMax);
	}
}
