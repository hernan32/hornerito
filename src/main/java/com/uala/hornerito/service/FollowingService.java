package com.uala.hornerito.service;

import com.fasterxml.jackson.databind.JsonNode;
import com.uala.hornerito.dto.request.FollowUserRequestDTO;
import org.springframework.http.ResponseEntity;

public interface FollowingService {

    ResponseEntity<JsonNode> saveFollow(FollowUserRequestDTO followUserRequestDTO);

}
