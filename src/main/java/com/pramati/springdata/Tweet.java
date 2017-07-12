package com.pramati.springdata;

import java.util.List;

public class Tweet {

	List<TweetDetail> tweets;
	
	int size;

	public List<TweetDetail> getTweets() {
		return tweets;
	}

	public void setTweets(List<TweetDetail> tweets) {
		this.tweets = tweets;
	}

	public int getSize() {
		return size;
	}

	public void setSize(int size) {
		this.size = size;
	}
	
	
	
	
}
