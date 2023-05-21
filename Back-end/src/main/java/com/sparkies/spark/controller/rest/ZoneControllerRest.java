package com.sparkies.spark.controller.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sparkies.spark.model.Zone;
import com.sparkies.spark.repository.ZoneRepo;

@RestController
@RequestMapping("api/zone")
@CrossOrigin(origins = "http://localhost:4200")
public class ZoneControllerRest {

	@Autowired
	ZoneRepo zoneRepo;

	/**
	 * Get all zone from DB
	 * 
	 * @return list of zone
	 */
	@GetMapping
	public Iterable<Zone> getAll() {
		return zoneRepo.findAll();
	}
}
