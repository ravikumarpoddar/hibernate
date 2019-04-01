package com.app.hibernate;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
@Entity
@Table(name="policestation_table")
public class PoliceStationDTO implements Serializable {
	@Column(name="no_of_cells")
	private int noOfCells;
	@Column(name="location")
	@Id
	private String location;
	@Column(name="no_of_prisoners")
	private int noOfPrisoners;

	// generate getters and setters
	public int getNoOfCells() {
		return noOfCells;
	}

	public void setNoOfCells(int noOfCells) {
		this.noOfCells = noOfCells;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public int getNoOfPrisoners() {
		return noOfPrisoners;
	}

	public void setNoOfPrisoners(int noOfPrisoners) {
		this.noOfPrisoners = noOfPrisoners;
	}

	public PoliceStationDTO() {
	}

}
