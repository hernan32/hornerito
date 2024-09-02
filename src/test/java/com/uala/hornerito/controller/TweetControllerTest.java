package com.uala.hornerito.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.uala.hornerito.dto.request.TweetRequestDTO;
import com.uala.hornerito.model.db.Tweet;
import com.uala.hornerito.service.TweetService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.web.servlet.MockMvc;

import static org.hamcrest.Matchers.matchesPattern;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
@ActiveProfiles("test")
class TweetControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private TweetService tweetService;

    @Autowired
    private ObjectMapper mapper;

    @Test
    public void givenUserId_whenGetTweetsEndpointIsAccessed_thenResponseIsReturned() throws Exception {
        int userId = 1;

        Tweet tweet = new Tweet();
        tweet.setId(2);
        tweet.setContent("test");
        tweet.setUserId(1);
        when(tweetService.getTweetById(userId)).thenReturn(ResponseEntity.ok(tweet));

        mockMvc.perform(get("/tweets?id=" + userId))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id").value(2))
                .andExpect(jsonPath("$.userId").value(1))
                .andExpect(jsonPath("$.content").value("test"))
                .andExpect(jsonPath("$.createDate").value(matchesPattern("^\\d{4}-\\d{2}-\\d{2}T\\d{2}:\\d{2}:\\d{2}\\.\\d{3}[+-]\\d{2}:\\d{2}$")));
    }

    @Test
    public void givenTweetRequest_whenSaveTweetsEndpointIsAccessed_thenIsSaved() throws Exception {
        String content = "Test Tweet Message Content";
        int userId = 1;
        TweetRequestDTO request = new TweetRequestDTO();
        request.setContent(content);
        request.setUserId(userId);

        Tweet tweet = new Tweet();
        tweet.setId(5);
        tweet.setContent(content);
        tweet.setUserId(userId);
        when(tweetService.saveTweet(request)).thenReturn(ResponseEntity.ok(tweet));

        mockMvc.perform(post("/tweets").content(mapper.writeValueAsString(request)).contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
    }

    @Test
    public void givenTweetRequestBigContent_whenSaveTweetsEndpointIsAccessed_thenAnErrorOccurs() throws Exception {
        String bigContent = "a".repeat(300);
        int userId = 1;
        TweetRequestDTO request = new TweetRequestDTO();
        request.setContent(bigContent);
        request.setUserId(userId);

        Tweet tweet = new Tweet();
        tweet.setId(5);
        tweet.setContent(bigContent);
        tweet.setUserId(userId);
        when(tweetService.saveTweet(request)).thenReturn(ResponseEntity.ok(tweet));

        mockMvc.perform(post("/tweets").content(mapper.writeValueAsString(request)).contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isBadRequest())
                .andExpect(jsonPath("$.content").value("Max content 280 characters."));
    }
}
