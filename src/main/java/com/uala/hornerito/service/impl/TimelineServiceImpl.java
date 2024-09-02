package com.uala.hornerito.service.impl;

import com.uala.hornerito.model.db.Tweet;
import com.uala.hornerito.repository.TweetRepository;
import com.uala.hornerito.service.TimelineService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.time.Instant;
import java.time.temporal.ChronoUnit;
import java.util.List;

@Slf4j
@Service
public class TimelineServiceImpl implements TimelineService {

    @Autowired
    TweetRepository tweetRepository;
    @Value("${service.timeline.interval.hours}")
    int hours;

    public List<Tweet> getTimelineByUserId(int id) {
        log.info("Interval {} for user {}.", hours, id);
        Instant limit = Instant.now().minus(hours, ChronoUnit.HOURS);
        Timestamp limitTimestamp = Timestamp.from(limit);
        return tweetRepository.getTimelineByUserId(id, limitTimestamp);
    }

}
