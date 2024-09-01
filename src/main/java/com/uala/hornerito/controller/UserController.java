package com.uala.hornerito.controller;

import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Tag(name = "User Hornerito", description = "User Endpoint")
@RequestMapping("/user")
public class UserController {


    @GetMapping()
    public String getUser(HttpServletRequest request, @RequestParam("id") int id) {
        return "Get some Foos with Header Old";
    }


}
