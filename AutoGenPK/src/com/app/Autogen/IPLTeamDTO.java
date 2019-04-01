package com.app.Autogen;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name = "ipl_table")
public class IPLTeamDTO implements Serializable {

	@Column(name = "team_name")
	private String teamName;

	@Column(name = "captain_Name")
	private String captainName;

	@Column(name = "no_Ofwins")
	private int noOfwins;

	@Column(name = "jersey_Color")
	private String jerseyColor;
	
	@Id
	@GenericGenerator(name="gen",strategy="increment")
	@GeneratedValue(generator="gen")
	@Column(name = "sl_no")
	private int slNo;

	public String getTeamName() {
		return teamName;
	}

	public void setTeamName(String teamName) {
		this.teamName = teamName;
	}

	public String getCaptainName() {
		return captainName;
	}

	public void setCaptainName(String captainName) {
		this.captainName = captainName;
	}

	public int getNoOfwins() {
		return noOfwins;
	}

	public void setNoOfwins(int noOfwins) {
		this.noOfwins = noOfwins;
	}

	public String getJerseyColor() {
		return jerseyColor;
	}

	public void setJerseyColor(String jerseyColor) {
		this.jerseyColor = jerseyColor;
	}

	public int getSlNo() {
		return slNo;
	}

	public void setSlNo(int slNo) {
		this.slNo = slNo;
	}

}
