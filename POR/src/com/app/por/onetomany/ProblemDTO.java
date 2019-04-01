package com.app.por.onetomany;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.ManyToAny;

@Entity
@Table(name = "prob_table")
public class ProblemDTO implements Serializable {

	@Id
	@Column(name = "prob_type")
	private String type;

	@Column(name = "prob_duration")
	private int duration;

	@JoinColumn(name="prob")
	@ManyToOne(cascade=CascadeType.ALL)
	private PersonDTO person;

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public int getDuration() {
		return duration;
	}

	public void setDuration(int duration) {
		this.duration = duration;
	}

	public PersonDTO getPerson() {
		return person;
	}

	public void setPerson(PersonDTO person) {
		this.person = person;
	}

}
