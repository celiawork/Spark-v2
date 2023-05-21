package com.sparkies.spark.service;

import com.sparkies.spark.model.Zone;

import antlr.collections.List;

public interface ZoneService {
	
	public void saveDataZone(Zone zone);
	
	public Iterable<Zone> findAll();
	
}
