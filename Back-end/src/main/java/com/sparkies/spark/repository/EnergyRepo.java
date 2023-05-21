package com.sparkies.spark.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.sparkies.spark.model.Energy;

@Repository
public interface EnergyRepo extends CrudRepository<Energy, Long> {

}
