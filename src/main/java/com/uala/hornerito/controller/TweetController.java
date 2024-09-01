package com.uala.hornerito.controller;

import com.uala.hornerito.dto.request.TweetRequestDTO;
import com.uala.hornerito.model.db.Tweet;
import com.uala.hornerito.service.TweetService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@Tag(name = "Tweets Hornerito", description = "Tweets Endpoint")
@RequestMapping("/tweets")
public class TweetController {

    @Autowired
    TweetService tweetService;


    @Operation(summary = "Get Tweet by id.")
    @GetMapping()
    public ResponseEntity<Tweet> getTweets(@RequestParam("id") int id) {
        return tweetService.getTweetById(id);
    }

    @Operation(summary = "Save Tweet.")
    @PostMapping()
    public ResponseEntity<Tweet> saveTweet(@RequestBody TweetRequestDTO tweetRequestDTO) {
        return tweetService.saveTweet(tweetRequestDTO);
    }


}
