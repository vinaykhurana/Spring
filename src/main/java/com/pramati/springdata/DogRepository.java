package com.pramati.springdata;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DogRepository extends CrudRepository<Dog, Integer> {

	void delete(Dog deleted);

	List<Dog> findAll();

	Dog findOne(int id);

	Dog save(Dog persisted);
}
