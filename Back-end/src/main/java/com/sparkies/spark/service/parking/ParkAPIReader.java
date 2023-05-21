package com.sparkies.spark.service.parking;



import com.sparkies.spark.model.api.Park;
import com.sparkies.spark.service.exception.ParkAPIReaderException;

/**
 * interface de lecture de l'API de disponibilité de parking en temps réél
 * @author Brigitte
 *
 */
public interface ParkAPIReader {
	/**
	 * Lit le fichier xml fourni via l'url <code>parkApiUrl</code> et retourne un objet de type Park 
	 * @return
	 * @throws ParkAPIReaderException 
	 */
	public Park readPark(String parkApiUrl) throws ParkAPIReaderException;
	
	
}
