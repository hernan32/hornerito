package com.uala.hornerito.service;

import com.fasterxml.jackson.databind.JsonNode;

public interface UserService {

    JsonNode getUserById(int id);

    void saveUser(String username);

}
