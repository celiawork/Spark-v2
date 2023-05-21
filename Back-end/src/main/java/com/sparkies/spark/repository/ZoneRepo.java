package com.sparkies.spark.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

import com.sparkies.spark.model.Zone;

public interface ZoneRepo extends JpaRepository<Zone, Long>{

}
