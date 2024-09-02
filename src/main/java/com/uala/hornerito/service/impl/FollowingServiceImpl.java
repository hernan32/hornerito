package com.uala.hornerito.service.impl;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.uala.hornerito.dto.request.FollowUserRequestDTO;
import com.uala.hornerito.model.db.Follow;
import com.uala.hornerito.repository.FollowRepository;
import com.uala.hornerito.service.FollowingService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class FollowingServiceImpl implements FollowingService {

    @Autowired
    FollowRepository followRepository;
    ObjectMapper mapper = new ObjectMapper();

    public ResponseEntity<JsonNode> saveFollow(FollowUserRequestDTO followUserRequestDTO) {
        Follow follow = new Follow();
        follow.setUserId(followUserRequestDTO.getUserId());
        follow.setFollowingId(followUserRequestDTO.getFollowingId());
        if (followUserRequestDTO.getFollowingId() == followUserRequestDTO.getUserId()) {
            JsonNode response = mapper.createObjectNode().put("error", "You can't follow yourself.");
            return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
        }
        follow = followRepository.save(follow);
        JsonNode node = mapper.valueToTree(follow);
        return new ResponseEntity<>(node, HttpStatus.OK);
    }
}
