package com.sparkies.spark.repository;



import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.sparkies.spark.model.AppUser;
import com.sparkies.spark.model.Role;

@Repository
@Transactional
public interface RoleRepo extends JpaRepository<Role, Long> {
	
	Role findByName(String name);

}
