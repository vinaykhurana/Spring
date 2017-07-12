package com.pramati.interaction;

import java.io.IOException;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.pramati.entity.TweetInput;
import com.pramati.requestMapper.TweetInputMapper;
import com.pramati.service.TweetService;
import com.pramati.springdata.Tweet;
import com.pramati.springdata.TweetDetail;

@Component
@Path("/api/tweets")
public class TweetEndPoint {

	@Autowired
	private TweetInputMapper readTweetMapper;

	@Autowired
	private TweetService tweetService;

	ObjectMapper mapper = new ObjectMapper();

	@Path("/postTweetToTwitterAndDB")
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response postTweetToDB(String inputJson) throws IOException {
		TweetInput inTweet = readTweetMapper.parseReadTweetJson(inputJson);
		TweetDetail td = tweetService.postTweetToTwitter(inTweet);
		tweetService.postTweetToDB(td);
		Response res = Response.status(HttpStatus.OK.value()).entity(td).build();
		return res;

	}

	@Path("/readAllFromTwitter")
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Response readAllfromTwitter() throws IOException {
		Tweet tweet = tweetService.readAllFromTwitter();
		Response res = Response.status(HttpStatus.OK.value()).entity(tweet).build();
		return res;

	}

	@Path("/readAllFromDB")
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Response readAllfromDB() throws IOException {
		Tweet tweet = tweetService.readAllFromDB();
		Response res = Response.status(HttpStatus.OK.value()).entity(tweet).build();
		return res;

	}

	@Path("/findOneFromDB")
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response findOnefromDB(String inputJson) throws IOException {
		TweetInput inTweet = readTweetMapper.parseReadTweetJson(inputJson);
		TweetDetail tweetDetail = tweetService.findOneFromDB(inTweet);
		Response res = Response.status(HttpStatus.OK.value()).entity(tweetDetail).build();
		return res;

	}
}