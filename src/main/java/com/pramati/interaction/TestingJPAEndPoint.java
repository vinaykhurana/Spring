package com.pramati.interaction;

import java.io.IOException;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.pramati.springdata.Car;
import com.pramati.springdata.CarId;
import com.pramati.springdata.CarRepository;
import com.pramati.springdata.Cellular;
import com.pramati.springdata.Dog;
import com.pramati.springdata.DogHouse;
import com.pramati.springdata.DogHouseRepository;
import com.pramati.springdata.Person;
import com.pramati.springdata.PersonRepository;

@Component
@Path("/api/jpa")
public class TestingJPAEndPoint {


	@Autowired
	private PersonRepository personRepo;
	
	@Autowired
	private CarRepository carRepo;
	
	
	@Autowired
	private DogHouseRepository dogHouseRepo;

	@PersistenceContext
	private EntityManager entityManager;

	ObjectMapper mapper = new ObjectMapper();

	@Path("/pushPerson")
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Person pushPerson() throws IOException {
		Person person = new Person();
		person.setName("Vinay");
		personRepo.save(person);
		return person;
		/*
		 * User user = userService.findById(id); String resS =
		 * mapper.writeValueAsString(user); Response res =
		 * Response.status(200).entity(resS).build(); return res;
		 */
	}

	@Path("/pushCar")
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Car pushCar() throws IOException {
		Car car = new Car();
		car.setBrand("Hyundai");
		car.setName("Creta");
		car.setSerial(123);
		carRepo.save(car);
		return car;
		/*
		 * User user = userService.findById(id); String resS =
		 * mapper.writeValueAsString(user); Response res =
		 * Response.status(200).entity(resS).build(); return res;
		 */
	}
	
	@Path("/findCar")
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Car findCar() throws IOException {
		CarId carId = new CarId(123,"Hyundai");
		Car car = carRepo.findOne(carId);
		return car;
		/*
		 * User user = userService.findById(id); String resS =
		 * mapper.writeValueAsString(user); Response res =
		 * Response.status(200).entity(resS).build(); return res;
		 */
	}
	
	@Path("/pushDogHouse")
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public DogHouse pushDogHouse() throws IOException {
		Dog dog = new Dog();
		dog.setId(13);
		dog.setName("Tomy");
		
		DogHouse dogHouse = new DogHouse();
		dogHouse.setDog(dog);
		dogHouse.setBrand("XYZ");
		dogHouseRepo.save(dogHouse);
		return dogHouse;
		/*
		 * User user = userService.findById(id); String resS =
		 * mapper.writeValueAsString(user); Response res =
		 * Response.status(200).entity(resS).build(); return res;
		 */
	}
	
	@Path("/pushPersonCell")
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Person pushPersonCell() throws IOException {
		Person person = new Person();
		person.setName("Vinay");
		
		Cellular cell = new Cellular();
		cell.setNumber(987654321);
		person.setCellular(cell);
		personRepo.save(person);
		return person;
		/*
		 * User user = userService.findById(id); String resS =
		 * mapper.writeValueAsString(user); Response res =
		 * Response.status(200).entity(resS).build(); return res;
		 */
	}

}