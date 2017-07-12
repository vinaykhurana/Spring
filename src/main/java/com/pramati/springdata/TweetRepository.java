package com.pramati.springdata;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TweetRepository extends CrudRepository <TweetDetail, Long>{

	void delete(TweetDetail deleted);
	 
    List<TweetDetail> findAll();
 
    TweetDetail findOne(Long id);
 
    TweetDetail save(TweetDetail persisted);
}
