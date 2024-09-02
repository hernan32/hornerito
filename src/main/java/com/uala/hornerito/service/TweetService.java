package com.uala.hornerito.service;

import com.uala.hornerito.dto.request.TweetRequestDTO;
import com.uala.hornerito.model.db.Tweet;
import org.springframework.http.ResponseEntity;

public interface TweetService {

    ResponseEntity<Tweet> getTweetById(int id);

    ResponseEntity<Tweet> saveTweet(TweetRequestDTO tweetRequestDTO);

}
