package com.sparkies.spark.registration.token;

import java.time.LocalDateTime;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class ConfirmationTokenService {
	
	@Autowired
	private ConfirmationTokenRepo confirmationTokenRepo;
	
/**
 * Save data of token in database  
 * @param token : ConfirmationToken class
 */
    public void saveConfirmationToken(ConfirmationToken token) {
    	confirmationTokenRepo.save(token);
    }

    /**
     * Find token by token in database
     * @param token
     * @return the response
     */
    public Optional<ConfirmationToken> getToken(String token) {
        return confirmationTokenRepo.findByToken(token);
    }

    /**
     * Update setConfirmedAt in database
     * @param token
     * @return the response
     */
    public int setConfirmedAt(String token) {
        return confirmationTokenRepo.updateConfirmedAt(
                token, LocalDateTime.now());
    }

}
