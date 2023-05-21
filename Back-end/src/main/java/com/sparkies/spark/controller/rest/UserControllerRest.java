package com.sparkies.spark.controller.rest;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.sparkies.spark.exception.ErrorEnergy;
import com.sparkies.spark.model.AppUser;
import com.sparkies.spark.model.Profile;
import com.sparkies.spark.repository.ProfileRepo;
import com.sparkies.spark.service.GainService;
import com.sparkies.spark.service.UserService;

@RestController
@RequestMapping("api/users")
@CrossOrigin(origins = "http://localhost:4200")
public class UserControllerRest {
	
	@Autowired
	ProfileRepo userRepo;
	
	@Autowired
	UserService userService;
	
	@Autowired
	GainService gainService;
	

	@GetMapping
	public ResponseEntity <List<AppUser>>getAllUser() {
		return ResponseEntity.ok().body(userService.getUser());
	}
	
	
	 @GetMapping("{email}")
	 public AppUser findByEmail(@PathVariable String email){
	     return userService.getUser(email);
	 };
	 
	 @GetMapping("/profile/{id}")
	 public AppUser findProfile(@PathVariable Long id){
	     return userService.findByIdProfile(id);
	 };
	
	 @GetMapping("/gain/{id}")
	 public int getGain(@PathVariable Long id){
	     return gainService.getGain(id);
	 };
	
	/**
	 * Update the gain to user in DB
	 * @param id : id of user
	 * @param newGain : gain earned by the user 
	 * @return response http
	 */
	@PatchMapping("/gain/{id}/{newGain}")
	@Transactional
	public ResponseEntity<Integer> updateGainUser(@PathVariable Long id, @PathVariable int newGain) {
		
		int gainUser = gainService.getGain(id);
		int gain = gainUser + newGain;
		 return ResponseEntity.ok(gainService.addGainToUser(gain, id));
	}

}
