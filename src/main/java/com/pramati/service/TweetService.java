package com.pramati.service;

import org.springframework.stereotype.Service;

import com.pramati.entity.TweetInput;
import com.pramati.springdata.Tweet;
import com.pramati.springdata.TweetDetail;

@Service
public interface TweetService {

	public TweetDetail postTweetToDB(TweetDetail td);

	public TweetDetail postTweetToTwitter(TweetInput input);

	public Tweet readAllFromTwitter();

	public Tweet readAllFromDB();

	public TweetDetail findOneFromDB(TweetInput input);
}