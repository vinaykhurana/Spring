package com.pramati.springdata;

import javax.persistence.*;

@Entity
@IdClass(CarId.class)
public class Car {
	@Id
	private int serial;
	@Id
	private String brand;

	private String name;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getSerial() {
		return serial;
	}

	public void setSerial(int serial) {
		this.serial = serial;
	}

	public String getBrand() {
		return brand;
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}
}
