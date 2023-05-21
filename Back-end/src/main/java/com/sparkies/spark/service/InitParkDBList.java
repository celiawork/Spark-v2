package com.sparkies.spark.service;

import com.sparkies.spark.model.Parking;
import com.sparkies.spark.model.Zone;
import com.sparkies.spark.repository.ParkingRepo;
import com.sparkies.spark.repository.ZoneRepo;
import com.sparkies.spark.service.parking.JSONParkLoader;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;

/**
 * Initialize Parking list in DB
 */
@Service
public class InitParkDBList {

	private static List<Parking> myParks;


	@Autowired
	ParkingRepo parkingRepository;


	/**
	 * Create 'Parkings' in DB from Json file
	 * @return List<Parking>
	 * @throws IOException Jackson Exception
	 */
	@Autowired
	public List<Parking> initialize() throws IOException {

		try {

			List<Parking> myParks = JSONParkLoader.getParksInfo();


			for (Parking myPark : myParks) {

				Parking newPark = new Parking(myPark);
				parkingRepository.save(newPark);
				System.out.println("########################");
				System.out.println(myPark);
			}

		} catch (IOException e) {
			e.printStackTrace();
		}
		return myParks;

	}
}
