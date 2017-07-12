package com.pramati.requestMapper;

import java.io.IOException;

import org.springframework.stereotype.Component;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.pramati.entity.TweetInput;

@Component
public class TweetInputMapper {

	public TweetInput parseReadTweetJson(String inputJson) throws JsonParseException, JsonMappingException, IOException {
		ObjectMapper mapper = new ObjectMapper();
		TweetInput inTweet = mapper.readValue(inputJson, TweetInput.class);
		
		return inTweet;
		
	}
}
