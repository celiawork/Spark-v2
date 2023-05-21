package com.sparkies.spark.repository;



import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.sparkies.spark.model.AppUser;
import com.sparkies.spark.model.Profile;

@Repository
public interface AppUserRepo extends JpaRepository<AppUser, Long>{
	
	Optional<AppUser> findById(Long id);
	
	AppUser findByEmail(String email);
	
	/**
	 * Update the fields in User table, enabled = true, isPMR = false, numberOfGain = 0
	 * @param email : email of user
	 */
	 @Transactional
	    @Modifying
	    @Query("UPDATE AppUser a " +
	            "SET a.enabled = TRUE, a.isPMR = false, a.numberOfGain = 0 WHERE a.email = ?1")
	    int enableAppUser(String email);
	 
	 /**
	  * Get user details from DB
	  * @param id
	  * @return the user
	  */
	 @Query("SELECT u  FROM AppUser u  WHERE u.id = :id")
	 AppUser getUserDetails(@Param("id")Long id);
	 

	 /**
	  * Get gain of user from DB
	  * @param id : id of user
	  * @return the gain of user
	  */
	 @Query("SELECT u.numberOfGain FROM AppUser u WHERE u.id = :id")
	 int getUserGain(@Param("id")Long id);
	 
	/**
	 * Update gain of user in DB
	 * @param newGain : gain earned by the user
	 * @param id : id of user
	 * @return the new accumulated gain
	 */
	 @Transactional 
	 @Modifying
	 @Query("UPDATE AppUser a SET a.numberOfGain = ?1 WHERE a.id = ?2")
	 int updateUserGain(int newGain, Long id);

}