package com.uala.hornerito.service;

import com.uala.hornerito.model.db.Tweet;

import java.util.List;

public interface TimelineService {

    List<Tweet> getTimelineByUserId(int id);

}
