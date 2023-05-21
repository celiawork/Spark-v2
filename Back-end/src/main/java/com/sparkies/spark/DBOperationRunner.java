package com.sparkies.spark;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.sparkies.spark.model.Energy;
import com.sparkies.spark.model.Role;
import com.sparkies.spark.model.Zone;
import com.sparkies.spark.repository.EnergyRepo;
import com.sparkies.spark.repository.RoleRepo;
import com.sparkies.spark.repository.ZoneRepo;

/**
 * Add data in database before the application has finished startup
 *
 */

@Component
public class DBOperationRunner implements CommandLineRunner {

	@Autowired
	ZoneRepo zoneRepo;
	
	@Autowired
	EnergyRepo energyRepo;
	
	@Autowired
	RoleRepo roleRepo;

	@Override
	public void run(String... args) throws Exception {
		

		Energy energy1 = new Energy(	
				1L,
				"thermique standard",
				193.0
				);

		Energy energy2 = new Energy(	
				2L,
				"electrique standard",
				19.8
				);

		Energy energy3 = new Energy(	
				3L,
				"moto standard",
				168.0
				);

		Energy energy4 = new Energy(	
				4L,
				"diesel",
				2640.0
				);

		Energy energy5 = new Energy(	
				5L,
				"essence",
				2392.0
				);

		energyRepo.saveAll(
				List.of(energy1,energy2,energy3,energy4,energy5)
				);


		System.out.println("----------Database Energy OK----------------------");
		

		Zone centreVille = new Zone(	
				1L,
				"Centre-ville",
				10
				);

		Zone parcRelais = new Zone(	
				2L,
				"Parc relais",
				3
				);

		Zone proximite = new Zone(	
				3L,
				"Proximité",
				7
				);

		zoneRepo.saveAll(
				List.of(centreVille,parcRelais,proximite)
				);

		System.out.println("----------Database Zone OK----------------------");


		
		Role roleUser = new Role(	
				null,
				"ROLE_USER"
				
				);
		
		Role roleAdmin = new Role(	
				null,
				"ROLE_ADMIN"
				);
		
		roleRepo.saveAll(List.of(roleUser,roleAdmin));

	}


}
