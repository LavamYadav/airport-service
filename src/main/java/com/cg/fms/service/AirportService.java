package com.cg.fms.service;

import java.util.List;

import com.cg.fms.dto.Airport;
import com.cg.fms.exceptions.AirportNotFoundException;

public interface AirportService {

	public List<Airport> getAllAirports() throws AirportNotFoundException;
	
	public Airport getAirportById(String airportCode) throws AirportNotFoundException;
}
