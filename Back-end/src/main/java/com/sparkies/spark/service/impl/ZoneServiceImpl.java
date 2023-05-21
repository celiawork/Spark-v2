package com.sparkies.spark.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sparkies.spark.model.Zone;
import com.sparkies.spark.repository.ZoneRepo;
import com.sparkies.spark.service.ZoneService;

@Service
public class ZoneServiceImpl implements ZoneService {
	
	@Autowired
	ZoneRepo zoneRepo;

	@Override
	public void saveDataZone(Zone zone) {
		
		zoneRepo.save(zone);
	}
	

	@Override
	public Iterable<Zone> findAll() {

		return zoneRepo.findAll();
	}
}
