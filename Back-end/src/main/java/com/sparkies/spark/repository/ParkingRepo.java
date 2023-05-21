package com.sparkies.spark.repository;

import com.sparkies.spark.model.Parking;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ParkingRepo extends CrudRepository<Parking, String> {

}
