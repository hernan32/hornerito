package com.uala.hornerito.service.impl;

import com.uala.hornerito.dto.request.TweetRequestDTO;
import com.uala.hornerito.model.db.Tweet;
import com.uala.hornerito.repository.TweetRepository;
import com.uala.hornerito.service.TweetService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class TweetServiceImpl implements TweetService {

    @Autowired
    TweetRepository tweetRepository;

    public ResponseEntity<Tweet> getTweetById(int id) {
        Tweet tweet = tweetRepository.getTweetById(id);
        return new ResponseEntity<>(tweet, HttpStatus.OK);
    }

    public ResponseEntity<Tweet> saveTweet(TweetRequestDTO tweetRequestDTO) {
        try {
            Tweet tweet = new Tweet();
            tweet.setUserId(tweetRequestDTO.getUserId());
            tweet.setContent(tweetRequestDTO.getContent());
            tweetRepository.save(tweet);
            return new ResponseEntity<>(tweet, HttpStatus.OK);
        } catch (Exception e) {
            log.error("Error: {}", e.getMessage());
            throw e;
        }
    }
}
