package com.pramati.springdata;

import java.io.Serializable;

import javax.persistence.*;

@Entity
public class DogHouse implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	private int dogId;
	
	
	@MapsId
	@OneToOne
	@JoinColumn(name = "dog_id")
	private Dog dog;
	private String brand;

	public Dog getDog() {
		return dog;
	}

	public void setDog(Dog dog) {
		this.dog = dog;
	}

	public String getBrand() {
		return brand;
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}
}
