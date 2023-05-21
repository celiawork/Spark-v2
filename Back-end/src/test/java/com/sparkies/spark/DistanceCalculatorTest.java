package com.sparkies.spark;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.sparkies.spark.model.Parking;
import com.sparkies.spark.repository.ParkingRepo;
import com.sparkies.spark.service.DistanceCalculator;


@SpringBootTest
public class DistanceCalculatorTest {
	@Autowired
	DistanceCalculator calculator;
	@Autowired	
	ParkingRepo parkingRepository;
	@Test
	void contextLoads() {
	}
	
	@Test
	public void testCalculateDistance() {
		Double refLat=43.610769;
		Double refLong=3.876716;
		List<Parking> parks=(List<Parking>) parkingRepository.findAll();
		parks.forEach(p->{
			double dist=calculator.distance(43.610769, 3.876716, p.getyLat(), p.getxLong(), DistanceCalculator.UNITE_KM); 
			System.out.println("distance pour "+p.getName()+" "+dist);
		});
	}
}
