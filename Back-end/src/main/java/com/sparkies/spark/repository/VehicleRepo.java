package com.sparkies.spark.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.sparkies.spark.model.Vehicle;

@Repository
public interface VehicleRepo extends CrudRepository<Vehicle, Long> {


}
