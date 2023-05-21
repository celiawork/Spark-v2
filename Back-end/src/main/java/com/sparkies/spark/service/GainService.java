package com.sparkies.spark.service;

import com.sparkies.spark.model.AppUser;
import com.sparkies.spark.model.Profile;

public interface GainService {

    public int getGain(Long id);
	
	public int calGain(int emissionCarbon);
    
    public int addGainToUser(int gain, Long id);
}

