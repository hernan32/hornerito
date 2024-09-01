package com.uala.hornerito.service.impl;

import com.uala.hornerito.dto.UserDTO;
import com.uala.hornerito.model.db.Users;
import com.uala.hornerito.repository.UserRepository;
import com.uala.hornerito.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserRepository repository;

    public UserDTO getUserById(int id) {
        Users users = repository.findUserById(id);
        UserDTO userDTO = new UserDTO();
        userDTO.setUsername(users.getUsername());
        userDTO.setId(users.getId());
        return userDTO;
    }

    public void saveUser(String username) {
        Users users = new Users(username);
        repository.save(users);
    }
}
