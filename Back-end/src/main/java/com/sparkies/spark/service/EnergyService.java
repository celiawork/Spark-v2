package com.sparkies.spark.service;

import java.util.Optional;

import org.springframework.stereotype.Service;

import com.sparkies.spark.model.Energy;
import com.sparkies.spark.model.Vehicle;

public interface EnergyService {

	public Iterable<Energy> getAllEnergy();

	public void deleteEnergy(final Long id);

	public Energy saveEnergy(Energy energy);

	public Optional<Energy> getOneEnergy(Long id);

}

