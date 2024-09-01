package com.uala.hornerito.repository;

import com.uala.hornerito.dto.UserDTO;
import com.uala.hornerito.model.db.Users;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class PersistenceEngine {

    @Autowired
    UserRepository userRepository;

    public UserDTO findUserById(int id) {
        Users users = userRepository.findUserById(id);
        // TODO: This should be automatically created.
        UserDTO result = new UserDTO();
        result.setId(users.getId());
        result.setUsername(users.getUsername());
        return result;
    }

    public void saveUser(String username) {
        Users users = new Users(username);
        try {
            userRepository.save(users);
        } catch (Exception e) {
            log.error("Error whn saving: {}", e.getMessage());
            throw e;
        }
    }
}
