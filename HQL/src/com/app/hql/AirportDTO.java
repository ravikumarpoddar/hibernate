package com.app.hql;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "airport_table")
public class AirportDTO implements Serializable {
	@Id
	@Column(name = "airport_name")
	private String airPortName;
	@Column(name = "airport_loc")
	private String location;
	@Column(name = "no_of_planes")
	private int numPlane;
	@Column(name = "airport_type")
	private String type;

	public AirportDTO() {

	}

	public String getAirPortName() {
		return airPortName;
	}

	public void setAirPortName(String airPortName) {
		this.airPortName = airPortName;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public int getNumPlane() {
		return numPlane;
	}

	public void setNumPlane(int numPlane) {
		this.numPlane = numPlane;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}
}
