package com.app.por;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "cm_table")
public class CMDTO implements Serializable {

	@Id
	@Column(name = "ph_no")
	private long phNo;

	@Column(name = "cm_name")
	private String cmName;

	@Column(name = "cm_party")
	private String party;

	@Column(name = "cm_salary")
	private int salary;
	
	@OneToOne(cascade=CascadeType.ALL)
	private StateDTO state;

	public String getCmName() {
		return cmName;
	}

	public void setCmName(String cmName) {
		this.cmName = cmName;
	}

	public String getParty() {
		return party;
	}

	public void setParty(String party) {
		this.party = party;
	}

	public int getSalary() {
		return salary;
	}

	public void setSalary(int salary) {
		this.salary = salary;
	}

	public long getPhNo() {
		return phNo;
	}

	public void setPhNo(long phNo) {
		this.phNo = phNo;
	}

	public StateDTO getState() {
		return state;
	}

	public void setState(StateDTO state) {
		this.state = state;
	}

}
