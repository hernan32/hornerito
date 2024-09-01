package com.uala.hornerito.controller;

import com.fasterxml.jackson.databind.JsonNode;
import com.uala.hornerito.dto.request.UserRequestDTO;
import com.uala.hornerito.service.UserService;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@RestController
@Tag(name = "User Hornerito", description = "User Endpoint")
@RequestMapping("/user")
@Controller
public class UserController {

    @Autowired
    UserService userService;

    @GetMapping()
    public JsonNode getUser(HttpServletRequest request, @RequestParam("id") int id) {
        return userService.getUserById(id);
    }

    @PostMapping()
    public void saveUser(@RequestBody UserRequestDTO user) {
        userService.saveUser(user.getUsername());
    }


}
