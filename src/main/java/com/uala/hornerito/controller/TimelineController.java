package com.uala.hornerito.controller;

import com.uala.hornerito.model.db.Tweet;
import com.uala.hornerito.service.TimelineService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@Tag(name = "Timeline Hornerito", description = "Timeline Endpoint")
@RequestMapping("/timeline")
public class TimelineController {

    @Autowired
    TimelineService timelineService;

    @GetMapping()
    @Operation(summary = "Get Timeline by user id.")
    public List<Tweet> getTimeline(@RequestParam("id") int userId) {
        return timelineService.getTimelineByUserId(userId);
    }


}
