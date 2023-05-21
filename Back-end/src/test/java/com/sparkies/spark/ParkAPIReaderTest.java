package com.sparkies.spark;

import static org.junit.Assert.assertEquals;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.sparkies.spark.model.api.Park;
import com.sparkies.spark.service.parking.ParkAPIReader;

@SpringBootTest
public class ParkAPIReaderTest {
	
	@Autowired
	ParkAPIReader reader;

	/**
	 * Test for API parking in Montpellier 
	 */
	@Test
	public void testParkAPI() {
		
		Park park=reader.readPark("https://data.montpellier3m.fr/sites/default/files/ressources/FR_MTP_TRIA.xml");
		assertEquals(park.getName(),"Triangle");
		System.out.println("Nom Parking: "+park.getName());
		System.out.println("Nbr places libres: "+park.getFree());
		System.out.println("Nbr total: "+park.getTotal());
	}
}
