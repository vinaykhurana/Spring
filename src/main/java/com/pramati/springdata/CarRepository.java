package com.pramati.springdata;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CarRepository extends CrudRepository<Car, CarId> {

	void delete(Car deleted);

	List<Car> findAll();

	Car findOne(CarId id);

	Car save(Car persisted);
}
