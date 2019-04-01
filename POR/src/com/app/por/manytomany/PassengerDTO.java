package com.app.por.manytomany;

import java.io.Serializable;
import java.util.Collection;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name = "pass_table")
public class PassengerDTO implements Serializable {

	@Column(name = "pass_type")
	private String type;

	@Id
	@Column(name = "ticket_no")
	private int ticketNo;

	@ManyToMany(cascade = CascadeType.ALL)
	private Collection<BusDTO> buses;

	public String getType() {
		return type;
	}

	public void setType(String Type) {
		this.type = Type;
	}

	public int getTicketNo() {
		return ticketNo;
	}

	public void setTicketNo(int ticketNo) {
		this.ticketNo = ticketNo;
	}

	public Collection<BusDTO> getBuses() {
		return buses;
	}

	public void setBuses(Collection<BusDTO> buses) {
		this.buses = buses;
	}

}
