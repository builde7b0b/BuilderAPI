package com.builderAPI.builder.controller;

import com.builderAPI.builder.model.User;
import com.builderAPI.builder.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/users")
public class UserController {

    @Autowired
    private UserService userService;


    @GetMapping(path = "/hello-world/")
    public String helloWorld() {
        return "Hello World!";
    }

    @GetMapping("/")
    public List<com.builderAPI.builder.model.User> getAllUsers() {
        return userService.getAllUsers();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Optional<User>> getUserById(@PathVariable(value = "id") Long userId) {
        Optional<User> user = userService.getUserById(userId);
        return ResponseEntity.ok().body(user);
    }




}
