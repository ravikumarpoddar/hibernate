package com.app.por;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;
@Entity
@Table(name="state_table")
public class StateDTO implements Serializable {

	@Id
	@Column(name="state_name")
	private String name;
	
	@Column(name="noOf_Districts")
	private int noOfDistricts;

	@Column(name="state_language")
	private String language;

	// reference of CM
	@OneToOne(cascade=CascadeType.ALL)
	private CMDTO cm;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getNoOfDistricts() {
		return noOfDistricts;
	}

	public void setNoOfDistricts(int noOfDistricts) {
		this.noOfDistricts = noOfDistricts;
	}

	public String getLanguage() {
		return language;
	}

	public void setLanguage(String language) {
		this.language = language;
	}

	public CMDTO getCm() {
		return cm;
	}

	public void setCm(CMDTO cm) {
		this.cm = cm;
	}

}
