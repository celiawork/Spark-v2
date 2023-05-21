package com.sparkies.spark.service.impl;

import java.net.URI;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Optional;
import java.util.UUID;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.sparkies.spark.model.AppUser;
import com.sparkies.spark.model.Profile;
import com.sparkies.spark.model.Role;
import com.sparkies.spark.registration.token.ConfirmationToken;
import com.sparkies.spark.registration.token.ConfirmationTokenService;
import com.sparkies.spark.repository.AppUserRepo;
import com.sparkies.spark.repository.ProfileRepo;
import com.sparkies.spark.repository.RoleRepo;
import com.sparkies.spark.service.UserService;

import lombok.AllArgsConstructor;

@Service
public class AppUserServiceImpl implements UserDetailsService {

	@Autowired
	private AppUserRepo userRepo;

	@Autowired
	private RoleRepo roleRepo;

	@Autowired
	private BCryptPasswordEncoder bCryptPasswordEncoder;

	@Autowired
	private ConfirmationTokenService confirmationTokenService;

	@Override
	@Transactional
	public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {

		AppUser user = userRepo.findByEmail(email);

		Collection<SimpleGrantedAuthority> authorities = new ArrayList<>();

		user.getRoles().forEach(role -> {
			authorities.add(new SimpleGrantedAuthority(role.getName()));
		});

		return new org.springframework.security.core.userdetails.User(user.getUsername(), user.getPassword(),
				authorities);
	}
	

	/**
	 * Save User in database
	 * 
	 * @param AppUser
	 * @return generated token
	 */
	@Transactional
	public String signUpUser(AppUser appUser) {

		AppUser isUserExists = userRepo.findByEmail(appUser.getEmail());

		if (isUserExists != null) {
			throw new IllegalStateException("email is already taken");
		}

		String encodePassword = bCryptPasswordEncoder.encode(appUser.getPassword());
		appUser.setPassword(encodePassword);

		Role roleUser = roleRepo.findById(1L).get();
		appUser.getRoles().add(roleUser);

		userRepo.save(appUser);

		String token = UUID.randomUUID().toString();
		ConfirmationToken confirmationToken = new ConfirmationToken(token, LocalDateTime.now(),
				LocalDateTime.now().plusMinutes(15), appUser);
		confirmationTokenService.saveConfirmationToken(confirmationToken);
		return token;
	}
	
	

	public ResponseEntity<Integer> enableAppUser(String email) {
		URI uri = URI.create(
				ServletUriComponentsBuilder.fromCurrentContextPath().path("api/registration/confirm").toString());
		return ResponseEntity.created(uri).body(userRepo.enableAppUser(email));

	}

}
