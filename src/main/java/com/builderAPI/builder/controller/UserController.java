package com.builderAPI.builder.controller;

import com.builderAPI.builder.services.UserService;

import java.util.List;

public class UserController {

    private UserService userService;

    public List<com.builderAPI.builder.model.User> getAllUsers() {
        return userService.getAllUsers();
    }
}
