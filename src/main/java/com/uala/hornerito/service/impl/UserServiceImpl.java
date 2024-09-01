package com.uala.hornerito.service.impl;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.uala.hornerito.model.db.Users;
import com.uala.hornerito.repository.UserRepository;
import com.uala.hornerito.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserRepository repository;
    ObjectMapper mapper = new ObjectMapper();

    public JsonNode getUserById(int id) {
        Users users = repository.findUserById(id);
        return mapper.valueToTree(users);
    }

    public void saveUser(String username) {
        Users users = new Users(username);
        repository.save(users);
    }
}
