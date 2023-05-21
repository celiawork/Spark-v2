package com.sparkies.spark.service.parking;

import java.util.List;

import com.sparkies.spark.model.Parking;

/**
 * Interface decrivant le service Parking. L'interface fournit les methode nessecaire 
 * afin de recuperer liés aux parking et aux places  de parking disponibles
 * @author Brigitte
 *
 */
public interface ParkingDisponibilityService {

	/**
	 * retourne la liste des parkings disponibles avec leurs données liées au parking
	 * @return
	 */
	List<Parking> getAllParking();

	/**
	 *  retourne la liste des parkings disponibles  autour d'un point à une distance maximum définie en km
	 *
	 * @param xlong
	 * @param Xlat
	 * @param maxRange distance max en km
	 * @return
	 */
	List<Parking> getParkingList(Double xLong, Double xLat, Double maxRange);

}
