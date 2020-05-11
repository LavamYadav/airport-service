package com.cg.fms.service;

import java.util.ArrayList;

import java.util.List;
import java.util.Optional;
import org.hibernate.annotations.common.util.impl.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.fms.dto.Airport;
import com.cg.fms.exceptions.AirportNotFoundException;
import com.cg.fms.repository.AirportRepository;

@Service
public class AirportServiceImpl implements AirportService{
	@Autowired
	AirportRepository airportRepository;
	
	private static final org.jboss.logging.Logger logger = LoggerFactory.logger(AirportServiceImpl.class);

    //getting all airports record by using the method findaAll() of CrudRepository
	public List<Airport> getAllAirports() throws AirportNotFoundException{
		List<Airport> airports = new ArrayList<Airport>();
		airportRepository.findAll().forEach(airport1 -> airports.add(airport1));
		if(airports.isEmpty())
		{
			logger.error("No Airport Found");
			throw new AirportNotFoundException("No airports Found , add airport to database");
			
		}
		
		logger.info("Retrieving all airports.");
		return airports;
	}

    //getting a specific record by using the method findById() of CrudRepository
	public Airport getAirportById(String airportCode) throws AirportNotFoundException{
		
		Optional<Airport> airport = airportRepository.findById(airportCode);
		if(!airport.isPresent())
		{
			logger.error("No Airport Found for code: "+airportCode);
			throw new AirportNotFoundException("No airport found with id "+ airportCode);
		}
		logger.info("Retrieved Airport for code: "+airportCode);
		logger.info("Returning found Airport.");
		return airport.get();
	}

}