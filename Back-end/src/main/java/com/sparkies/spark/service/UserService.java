package com.sparkies.spark.service;

import java.util.List;
import java.util.Optional;

import com.sparkies.spark.model.AppUser;
import com.sparkies.spark.model.Profile;
import com.sparkies.spark.model.Role;

public interface UserService {
	
	AppUser getUser(String email);
	AppUser findByIdProfile(Long id);
	List<AppUser>getUser();
	
	Role saveRole(Role role);
	void addRoleToUser(String username, String roleName);

}
