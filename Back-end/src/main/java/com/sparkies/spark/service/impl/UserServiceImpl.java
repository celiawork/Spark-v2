package com.sparkies.spark.service.impl;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Optional;

import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sparkies.spark.model.AppUser;
import com.sparkies.spark.model.Profile;
import com.sparkies.spark.model.Role;
import com.sparkies.spark.repository.AppUserRepo;
import com.sparkies.spark.repository.ProfileRepo;
import com.sparkies.spark.repository.RoleRepo;
import com.sparkies.spark.service.UserService;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Service
@RequiredArgsConstructor
@Transactional
@Slf4j
public class UserServiceImpl implements UserService {

	@Autowired
	private AppUserRepo userRepo;

	@Autowired
	private RoleRepo roleRepo;
	
	@Override
	public Role saveRole(Role role) {
		return roleRepo.save(role);		
	}

	@Override
	public void addRoleToUser(String email, String roleName) {
		AppUser user = userRepo.findByEmail(email);
		Role role = roleRepo.findByName(roleName);
		user.getRoles().add(role);
	}
	

	@Override
	public AppUser getUser(String email) {
		return userRepo.findByEmail(email);
	}
	

	@Override
	public List<AppUser> getUser() {
		return userRepo.findAll();
	}

	@Override
	public AppUser findByIdProfile(Long id) {
		return userRepo.getUserDetails(id);
	}

}
