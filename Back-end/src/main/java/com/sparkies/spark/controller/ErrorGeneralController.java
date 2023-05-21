package com.sparkies.spark.controller;

import org.springframework.http.HttpStatus;

import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.sparkies.spark.exception.ErrorEnergy;
import com.sparkies.spark.exception.ErrorVehicle;


@RestControllerAdvice
public class ErrorGeneralController {

	/**
	 * General error 
	 * @param e -> exception
	 * @return the message of error
	 */
	@ExceptionHandler(value = { Exception.class })
	@ResponseStatus(value = HttpStatus.BAD_REQUEST)
	public String errorGeneralException(Exception e) {
		String message = "Il y a une erreur : " + e.getMessage();
		return message;
	}
	
	/**
	 * Vehicle error
	 * @param e -> exception
	 * @return the message of error
	 */
	@ExceptionHandler(value = { ErrorVehicle.class })
	@ResponseStatus(value = HttpStatus.NOT_FOUND)
	public String errorVehicleException(ErrorVehicle e) {
		String message = "Erreur lié au vehicule : " + e.getMessage();
		return message;
	}
	
	/**
	 * Energy error
	 * @param e -> exception
	 * @return the message of error
	 */
	@ExceptionHandler(value = { ErrorEnergy.class })
	@ResponseStatus(value = HttpStatus.NOT_FOUND)
	public String errorEnergyException(ErrorEnergy e) {
		String message = "Erreur lié au energie : " + e.getMessage();
		return message;
	}
}


