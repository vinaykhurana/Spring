package com.pramati.service;

import java.util.ArrayList;
import java.util.List;

import twitter4j.Paging;
import twitter4j.Status;
import twitter4j.Twitter;
import twitter4j.TwitterException;
import twitter4j.TwitterFactory;
import twitter4j.User;
import twitter4j.auth.AccessToken;
import twitter4j.conf.ConfigurationBuilder;

public class JavaTweet {

	static String consumerKeyStr = "GzDogWHhNqOTiVVeMzLvSwz7S";
	static String consumerSecretStr = "4byAzjfT91ZtYSW0OVz7C6CwKOTMtjvekSrHKC2qDHViOXaMFR";
	static String accessTokenStr = "883278617001705472-rpQsJ0BrGUIkZObdo5DgcvhG0tn9OrN";
	static String accessTokenSecretStr = "D3YiiPRMByjwBskTF86BIhyYS8STbKxbOEGi66lk9WfY4";

	public static void main(String[] args) throws TwitterException {

		getTweetsUsingTwitter4j();
	/*	try {
			Twitter twitter = new TwitterFactory().getInstance();

			twitter.setOAuthConsumer(consumerKeyStr, consumerSecretStr);
			AccessToken accessToken = new AccessToken(accessTokenStr,
					accessTokenSecretStr);

			twitter.setOAuthAccessToken(accessToken);

			twitter.updateStatus("Post using Twitter4J Again");

			System.out.println("Successfully updated the status in Twitter.");
		} catch (TwitterException te) {
			te.printStackTrace();
		}*/
	}

	
	public static void getTweetsUsingTwitter4j() throws TwitterException {
		Twitter twitter = TwitterFactory.getSingleton();
		twitter.setOAuthConsumer(consumerKeyStr, consumerSecretStr);
		AccessToken accessToken = new AccessToken(accessTokenStr,
				accessTokenSecretStr);

		twitter.setOAuthAccessToken(accessToken);

	    List<Status> statuses = twitter.getUserTimeline();
	    System.out.println("Showing home timeline.");
	    for (Status status : statuses) {
	        System.out.println(status.getUser().getName() + ":" +
	                           status.getText());
	    }
	}
	public static void getTweets() {
		 ConfigurationBuilder cb = new ConfigurationBuilder();
		    cb.setOAuthConsumerKey(consumerKeyStr);
		    cb.setOAuthConsumerSecret(consumerSecretStr);
		    cb.setOAuthAccessToken(accessTokenStr);
		    cb.setOAuthAccessTokenSecret(accessTokenSecretStr);

		    Twitter twitter = new TwitterFactory(cb.build()).getInstance();

		    int pageno = 1;
		    String user = "testuser2609";
		    List<Status> statuses = new ArrayList();

		    while (true) {

		      try {

		        int size = statuses.size(); 
		        Paging page = new Paging(pageno++, 100);
		        statuses.addAll(twitter.getUserTimeline(user, page));
		        if (statuses.size() == size)
		          break;
		      }
		      catch(TwitterException e) {

		        e.printStackTrace();
		      }
		    }

		    System.out.println("Total: "+statuses.size());
	}
}