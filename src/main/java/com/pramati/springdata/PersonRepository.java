package com.pramati.springdata;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PersonRepository extends CrudRepository<Person, Long> {

	void delete(Person deleted);

	List<Person> findAll();

	Person findOne(Long id);

	Person save(Person persisted);
}
