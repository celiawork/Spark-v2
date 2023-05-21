package com.sparkies.spark.service.parking;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.sparkies.spark.model.Parking;
import org.springframework.stereotype.Component;

import java.io.File;
import java.io.IOException;
import java.util.List;

/**
 * Convert JSON File to Java Objects
 */
@Component
public class JSONParkLoader {

    ObjectMapper mapper = new ObjectMapper();
    /**
     * Create Java 'Parking' Objects with JSON File
     * @return type : List<Parking>
     * @throws IOException Jackson Exception
     */
    public static List<Parking> getParksInfo() throws IOException {

        // Convert JSON to Java 'Parking' objects
        ObjectMapper mapper = new ObjectMapper();
        List<Parking> myParks = mapper.readValue(jsonFile(), new TypeReference<List<Parking>>(){});
        System.out.println("###########################################");
        System.out.println("###########################################");
        System.out.println("###########################################");
        System.out.println("List des Parkings via Jackson : " + myParks);

        return myParks;
    }

    /**
     * Connect and return JSON File
     * @return type : JSON File
     */
    private static File jsonFile() {
        return new File("src/main/resources/json/parkOuvrage.json");
    }

}
