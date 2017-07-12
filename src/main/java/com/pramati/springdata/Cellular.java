package com.pramati.springdata;

import javax.persistence.*;

@Entity
public class Cellular {
	@Id
	@GeneratedValue
	private int id;
	private int number;

	// get and set
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getNumber() {
		return number;
	}

	public void setNumber(int number) {
		this.number = number;
	}
/*
	@OneToOne(mappedBy = "cellular")
	private Person person;

	public Person getPerson() {
		return person;
	}

	public void setPerson(Person person) {
		this.person = person;
	}*/

}
