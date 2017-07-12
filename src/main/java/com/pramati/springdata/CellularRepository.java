package com.pramati.springdata;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CellularRepository extends CrudRepository<Cellular, Integer> {

	void delete(Cellular deleted);

	List<Cellular> findAll();

	Cellular findOne(Integer id);

	Cellular save(Cellular persisted);
}
