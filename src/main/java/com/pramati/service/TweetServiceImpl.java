package com.pramati.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pramati.constants.TwitterConstants;
import com.pramati.entity.TweetInput;
import com.pramati.springdata.Tweet;
import com.pramati.springdata.TweetDetail;
import com.pramati.springdata.TweetRepository;

import twitter4j.Paging;
import twitter4j.Status;
import twitter4j.Twitter;
import twitter4j.TwitterException;
import twitter4j.TwitterFactory;
import twitter4j.auth.AccessToken;
import twitter4j.conf.ConfigurationBuilder;

@Service
public class TweetServiceImpl implements TweetService {

	@Autowired
	private TweetRepository tweetRepo;

	@Override
	public TweetDetail postTweetToTwitter(TweetInput input) {
		TweetDetail td = null;
		try {
			Twitter twitter = new TwitterFactory().getInstance();

			twitter.setOAuthConsumer(TwitterConstants.consumerKeyStr, TwitterConstants.consumerSecretStr);
			AccessToken accessToken = new AccessToken(TwitterConstants.accessTokenStr,
					TwitterConstants.accessTokenSecretStr);

			twitter.setOAuthAccessToken(accessToken);

			Status status = twitter.updateStatus(input.getTweetText());

			System.out.println("Successfully updated the status in Twitter.");

			td = new TweetDetail();
			td.setTweetText(input.getTweetText());
			td.setTweetId(status.getId());
		} catch (TwitterException te) {
			te.printStackTrace();
		}

		return td;
	}

	@Override
	public TweetDetail postTweetToDB(TweetDetail td) {
		return tweetRepo.save(td);
	}

	@Override
	public Tweet readAllFromTwitter() {

		Tweet tweet = new Tweet();
		ConfigurationBuilder cb = new ConfigurationBuilder();
		cb.setOAuthConsumerKey(TwitterConstants.consumerKeyStr);
		cb.setOAuthConsumerSecret(TwitterConstants.consumerSecretStr);
		cb.setOAuthAccessToken(TwitterConstants.accessTokenStr);
		cb.setOAuthAccessTokenSecret(TwitterConstants.accessTokenSecretStr);

		Twitter twitter = new TwitterFactory(cb.build()).getInstance();

		int pageno = 1;

		List<Status> statuses = new ArrayList();

		while (true) {

			try {

				int size = statuses.size();
				Paging page = new Paging(pageno++, 100);
				statuses.addAll(twitter.getUserTimeline(TwitterConstants.user, page));
				if (statuses.size() == size)
					break;
			} catch (TwitterException e) {

				e.printStackTrace();
			}
		}

		List<TweetDetail> tweets = new ArrayList();
		for (Status status : statuses) {
			TweetDetail td = new TweetDetail(status.getText(), status.getId());
			tweets.add(td);
		}
		tweet.setTweets(tweets);
		tweet.setSize(tweets.size());
		// System.out.println("Total: " + statuses.size());

		return tweet;
	}

	@Override
	public Tweet readAllFromDB() {
		List<TweetDetail> tweetDetails = tweetRepo.findAll();

		Tweet tweet = new Tweet();
		tweet.setTweets(tweetDetails);
		tweet.setSize(tweetDetails.size());

		return tweet;
	}

	@Override
	public TweetDetail findOneFromDB(TweetInput input) {
		TweetDetail tweetDetail = tweetRepo.findOne(input.getId());

		return tweetDetail;
	}

}
