package com.pramati.springdata;

import java.io.Serializable;

public class CarId implements Serializable {
	private static final long serialVersionUID = 343L;
	private int serial;
	private String brand;

	// must have a default construcot
	public CarId() {
	}

	public CarId(int serial, String brand) {
		this.serial = serial;
		this.brand = brand;
	}

	public int getSerial() {
		return serial;
	}

	public String getBrand() {
		return brand;
	}

	// Must have a hashCode method
	@Override
	public int hashCode() {
		return serial + brand.hashCode();
	}

	// Must have an equals method
	@Override
	public boolean equals(Object obj) {
		if (obj instanceof CarId) {
			CarId carId = (CarId) obj;
			return carId.serial == this.serial && carId.brand.equals(this.brand);
		}
		return false;
	}
}