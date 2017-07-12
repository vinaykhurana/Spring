package com.pramati.springdata;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DogHouseRepository extends CrudRepository<DogHouse, Integer> {

	void delete(DogHouse deleted);

	List<DogHouse> findAll();

	DogHouse findOne(int id);

	DogHouse save(DogHouse persisted);
}
