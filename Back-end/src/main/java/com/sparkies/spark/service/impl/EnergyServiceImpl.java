package com.sparkies.spark.service.impl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sparkies.spark.model.Energy;
import com.sparkies.spark.repository.EnergyRepo;
import com.sparkies.spark.service.EnergyService;

@Service
public class EnergyServiceImpl implements EnergyService {

	@Autowired
	EnergyRepo energyRepo;

	@Override
	public Iterable<Energy> getAllEnergy() {
		return energyRepo.findAll();
	}

	@Override
	public void deleteEnergy(Long id) {
		energyRepo.deleteById(id);
	}

	@Override
	public Energy saveEnergy(Energy energy) {
		return energyRepo.save(energy);
	}

	@Override
	public Optional<Energy> getOneEnergy(Long id) {
		return energyRepo.findById(id);
	}

}
