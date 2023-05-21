package com.sparkies.spark.service.parking;

import com.sparkies.spark.model.Parking;

import java.util.Collection;

/**
 * Parking Service Interface
 * to manipulate ('Parking') Objects
 */
public interface ParkingService {

    Collection<Parking> findAll();
    Parking findOne(String id);
    Parking createOne(Parking parking);
    Parking updateOne(Parking parking);
    void deleteOne(String id);
}
