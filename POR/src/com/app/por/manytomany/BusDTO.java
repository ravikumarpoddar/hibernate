package com.app.por.manytomany;

import java.io.Serializable;
import java.util.Collection;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name = "bus_table")
public class BusDTO implements Serializable {

	@Id
	@GenericGenerator(name = "gen", strategy = "increment")
	@GeneratedValue(generator = "gen")
	@Column(name = "sl_no")
	private int slNo;
	@Column(name = "bus_number")
	private String number;

	@Column(name = "bus_color")
	private String color;

	@Column(name = "bus_destination")
	private String destination;

	@Column(name = "noOf_Seats")
	private int noOfSeats;
	
	@ManyToMany(cascade=CascadeType.ALL)
	private Collection<PassengerDTO> passengers;

	public String getNumber() {
		return number;
	}

	public void setNumber(String number) {
		this.number = number;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public String getDestination() {
		return destination;
	}

	public void setDestination(String destination) {
		this.destination = destination;
	}

	public int getNoOfSeats() {
		return noOfSeats;
	}

	public void setNoOfSeats(int noOfSeats) {
		this.noOfSeats = noOfSeats;
	}

	public Collection<PassengerDTO> getPassengers() {
		return passengers;
	}

	public void setPassengers(Collection<PassengerDTO> passengers) {
		this.passengers = passengers;
	}

	public int getSlNo() {
		return slNo;
	}

	public void setSlNo(int slNo) {
		this.slNo = slNo;
	}

}
