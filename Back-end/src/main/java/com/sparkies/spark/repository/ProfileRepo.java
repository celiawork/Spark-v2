package com.sparkies.spark.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import com.sparkies.spark.model.AppUser;
import com.sparkies.spark.model.Profile;

public interface ProfileRepo extends JpaRepository<Profile, Long>{
	
	

}
