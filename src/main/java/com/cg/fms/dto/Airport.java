package com.cg.fms.dto;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.validation.constraints.NotEmpty;

/**
 * @author Lavam
 * description: Airport Model
 */

@Entity

public class Airport {
	@Id
	private String airportCode;
	
	@NotEmpty(message = "Airport Name is Empty ")
	private String airportName;
	
	@NotEmpty(message = "Airport location is Empty ")
	private String airportLocation;
	
	

	public String getAirportCode() {
		return airportCode;
	}

	public void setAirportCode(String airportCode) {
		this.airportCode = airportCode;
	}

	public String getAirportName() {
		return airportName;
	}

	public void setAirportName(String airportName) {
		this.airportName = airportName;
	}

	public String getAirportLocation() {
		return airportLocation;
	}

	public void setAirportLocation(String airportLocation) {
		this.airportLocation = airportLocation;
	}

	public Airport(String airportCode, String airportName, String airportLocation) {
		super();
		this.airportCode = airportCode;
		this.airportName = airportName;
		this.airportLocation = airportLocation;
	}

	public Airport() {
		super();

	}

}
