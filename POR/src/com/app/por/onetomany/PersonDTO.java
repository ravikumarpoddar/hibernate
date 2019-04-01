package com.app.por.onetomany;

import java.io.Serializable;
import java.util.Collection;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;
@Entity
@Table(name="person_table")
public class PersonDTO implements Serializable {	
	
	@Id
	@GenericGenerator(name="gen",strategy="increment")
	@GeneratedValue(generator="gen")
	@Column(name="ph_no")
	private long ph_no;
	@Column(name="per_name")
	private String name;

	@Column(name="per_nationality")
	private String nationality;

	@Column(name="per_qulalification")
	private String qulalification;

	@Column(name="bank_balance")
	private double bankBalance;
	
	@JoinColumn(name="prob")
	@OneToMany(cascade=CascadeType.ALL)
	private Collection<ProblemDTO> probs;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getNationality() {
		return nationality;
	}

	public void setNationality(String nationality) {
		this.nationality = nationality;
	}

	public String getQulalification() {
		return qulalification;
	}

	public void setQulalification(String qulalification) {
		this.qulalification = qulalification;
	}

	public double getBankBalance() {
		return bankBalance;
	}

	public void setBankBalance(double bankBalance) {
		this.bankBalance = bankBalance;
	}

	public Collection<ProblemDTO> getProbs() {
		return probs;
	}

	public void setProbs(Collection<ProblemDTO> probs) {
		this.probs = probs;
	}

}
