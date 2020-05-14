package com.cg.fms.controller;

import java.util.List;
import java.util.Optional;

import org.hibernate.annotations.common.util.impl.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.cg.fms.dto.Airport;
import com.cg.fms.exceptions.AirportNotFoundException;
import com.cg.fms.payload.RestResponse;
import com.cg.fms.service.AirportServiceImpl;

@RestController
@CrossOrigin(origins = "*", maxAge = 3600)
@RequestMapping("/airport")
public class AirportController {
    @Autowired
    AirportServiceImpl airportService;
    private static final org.jboss.logging.Logger logger = LoggerFactory.logger(AirportServiceImpl.class);


    //creating a get mapping that retrieves all the airports detail from the database
    @GetMapping("/getAirports")
    private ResponseEntity<?> getAirports() {

        List<Airport> airports;
        try {
            logger.info("Retrieving all airports.");

            airports = airportService.getAllAirports();

            return ResponseEntity.ok(new RestResponse<>(true, "Airports found", airports));
        } catch (AirportNotFoundException e) {

            logger.error("No Airport Found");

            return ResponseEntity.ok(new RestResponse<>(false, e.getMessage()));
        }

    }

    //creating a get mapping that retrieves the detail of a specific airport
    @GetMapping("/getAirportById/{airportCode}")
    private ResponseEntity<?> getAirportById(@PathVariable("airportCode") Optional<String> airportCode) {
        if (!airportCode.isPresent() || airportCode.get().isEmpty()) {
            return ResponseEntity.ok(new RestResponse<>(false, "Airport code missing"));
        }
        try {
            logger.info("Retrieved Airport for code: " + airportCode);
            logger.info("Returning found Airport.");
            return ResponseEntity.ok(new RestResponse<>(true, "Airports found", airportService.getAirportById(airportCode.get())));
        } catch (AirportNotFoundException e) {

            logger.error("No Airport Found for code: " + airportCode);
            return ResponseEntity.ok(new RestResponse<>(false, e.getMessage()));
        }

    }
}
