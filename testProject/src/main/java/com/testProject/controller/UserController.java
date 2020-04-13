package com.testProject.controller;

import com.testProject.Service.UserService;
import com.testProject.models.Acknowledge;
import com.testProject.models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping(value = "/user")
    public ResponseEntity<?> addNewUser(@RequestBody User user){
        return userService.addNewUser(user);
    }
}
