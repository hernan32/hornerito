package com.uala.hornerito.service;

import com.uala.hornerito.dto.UserDTO;

public interface UserService {

    UserDTO getUserById(int id);
    void saveUser(String username);

}
