package com.uala.hornerito.controller;

import com.fasterxml.jackson.databind.JsonNode;
import com.uala.hornerito.dto.request.FollowUserRequestDTO;
import com.uala.hornerito.service.FollowingService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Tag(name = "Follows Hornerito", description = "Follows Endpoint")
@RequestMapping("/follows")
public class FollowController {

    @Autowired
    FollowingService followingService;


    @Operation(summary = "Follow user.")
    @PostMapping()
    public ResponseEntity<JsonNode> followUser(@Valid @RequestBody FollowUserRequestDTO followUserDto) {
        return followingService.saveFollow(followUserDto);
    }
}
