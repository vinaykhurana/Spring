package com.pramati.springdata;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "tweets")
public class TweetDetail implements Serializable {

	public TweetDetail() {}
	
	@Column(name = "tweetText", length = 5000)
	private String tweetText;

	@Id
	//@GeneratedValue(strategy = GenerationType.AUTO)
	private long tweetId;

	public TweetDetail(String tweetText, long tweetId) {
		this.tweetText = tweetText;
		this.tweetId = tweetId;
	}
	
	public TweetDetail(String tweetText) {
		this.tweetText = tweetText;
	}

	public String getTweetText() {
		return tweetText;
	}

	public void setTweetText(String tweetText) {
		this.tweetText = tweetText;
	}

	public long getTweetId() {
		return tweetId;
	}

	public void setTweetId(long tweetId) {
		this.tweetId = tweetId;
	}

	private static final long serialVersionUID = 1L;
	// setter, getter ignored
}