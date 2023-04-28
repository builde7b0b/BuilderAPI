package com.builderAPI.builder.controller;

public class UserController {

    private UserService userService;

    public List<com.builderAPI.builder.Model.User> getAllUsers() {
        return userService.getAllUsers();
    }
}
