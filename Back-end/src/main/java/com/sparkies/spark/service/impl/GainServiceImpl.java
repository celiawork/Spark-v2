
package com.sparkies.spark.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sparkies.spark.model.AppUser;
import com.sparkies.spark.model.Profile;
import com.sparkies.spark.repository.AppUserRepo;

import com.sparkies.spark.service.GainService;


@Service
public class GainServiceImpl implements GainService {
	
	@Autowired
	AppUserRepo userRepo;

	/**
	 * Get gain of user
	 */
	@Override
	public int getGain(Long id) {
		return userRepo.getUserGain(id);
	}

	/**
	 * Method to calculate the gain from emission carbon
	 */
	@Override
	public int calGain(int emissionCarbon) {
		int cal =  (int) Math.ceil(emissionCarbon / 100);
		return cal;
	}

	@Override
	public int addGainToUser(int gain, Long id) {
		return userRepo.updateUserGain(gain, id);
	}
	


}


