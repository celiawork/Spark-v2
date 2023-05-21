package com.sparkies.spark.service.impl.parking;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.sparkies.spark.model.Parking;
import com.sparkies.spark.model.api.Park;
import com.sparkies.spark.repository.ParkingRepo;
import com.sparkies.spark.service.DistanceCalculator;
import com.sparkies.spark.service.exception.ParkAPIReaderException;
import com.sparkies.spark.service.parking.ParkAPIReader;
import com.sparkies.spark.service.parking.ParkingDisponibilityService;

@Service
public class ParkingDisponibilityServiceImpl implements ParkingDisponibilityService {
	
	@Autowired
	ParkAPIReader reader;
	@Autowired
	DistanceCalculator distanceCalculator;
	@Autowired	
	ParkingRepo parkingRepository;

	@Override
	public List<Parking> getAllParking() {
		List <Parking> parkings=(List<Parking>) parkingRepository.findAll();
		parkings.forEach(parking->{
			Park park;
			try {
				park = reader.readPark(parking.getApiUrl());
			} catch (ParkAPIReaderException e) {				
				e.printStackTrace();
				park=null;
			}
			if(park!=null)parking.setFreeCapacity(park.getFree());
		});
		return parkings;
	}



	@Override
	public List<Parking> getParkingList(Double xLong, Double xLat, Double maxRange) {
		
		List <Parking> list=getAllParking();
		
		Iterator<Parking> it=list.stream().filter(p->{
			return isWithinPerimeter(p,xLong,xLat,maxRange);
		}
		).iterator();
		List <Parking> filteredList=new ArrayList<Parking>();
		while(it.hasNext()) {
			filteredList.add(it.next());
		}
		return filteredList;
	}
	/**
	 *  return true si  la distance entre  le parking et  le point de reference de coordonnées refLong et refLat  est inférieure ou égale à  maxRange
	 *  max Rage est exprimé en km
	 *
	 */
	private boolean isWithinPerimeter (Parking parking, Double refLong, Double refLat, Double maxRange ) {
		Double parkingLong=parking.getxLong();
		Double parkingLat=parking.getyLat();
		Double distance =distanceCalculator.distance(parkingLat, parkingLong, refLat, refLong, DistanceCalculator.UNITE_KM);
		return (distance<=maxRange);
	}

}
