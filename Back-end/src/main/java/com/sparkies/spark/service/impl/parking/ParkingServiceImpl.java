package com.sparkies.spark.service.impl.parking;

import com.sparkies.spark.model.Parking;
import com.sparkies.spark.repository.ParkingRepo;
import com.sparkies.spark.service.parking.ParkingService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.Optional;

@Service
public class ParkingServiceImpl implements ParkingService {
    @Autowired
    private ParkingRepo parkingRepository;

    @Override
    public Collection<Parking> findAll() {
        return (Collection<Parking>) parkingRepository.findAll();
    }

    @Override
    public Parking findOne(String id) {
        Optional<Parking> parking = parkingRepository.findById(id);
        return parking.get();
    }

    @Override
    public Parking createOne(Parking parking) {
        if (parking.getIdParking() != null) {
            System.out.println("Cannot create Parking - Specified id already exist !");
            return null;
        }
        Parking savedParking = parkingRepository.save(parking);
        return savedParking;
    }

    @Override
    public Parking updateOne(Parking parking) {
        Parking parkingPersisted = findOne(parking.getIdParking());
        if (parkingPersisted == null) {
            System.out.println("Cannot find specified Parking with id !");
            return null;
        }
        Parking updatedParking = parkingRepository.save(parking);
        return updatedParking;
    }

    @Override
    public void deleteOne(String id) {
        parkingRepository.deleteById(id);
    }
}
