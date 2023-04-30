package com.builderAPI.builder.controller;

import com.builderAPI.builder.model.User;
import com.builderAPI.builder.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.config.ConfigDataResourceNotFoundException;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/users")
public class UserController {

    @Autowired
    private UserService userService;

    /**
     * Returns a "Hello World!" message.
     *
     * @return A "Hello world!" message.
     */
    @GetMapping(path = "/hello-world/")
    public String helloWorld() {
        return "Hello World!";
    }

    /**
     * Returns a list of all users in the system.
     *
     * @return List of all users.
     */
    @GetMapping("/")
    public List<com.builderAPI.builder.model.User> getAllUsers() {
        return userService.getAllUsers();
    }

    /**
     * Retrieves a user by their ID
     *
     * @param userId The ID of the user to retrieve.
     * @return ResponseEntity containing the user if found, 404 Not found otherwise
     */
    @GetMapping("/{id}")
    public ResponseEntity<Optional<User>> getUserById(@PathVariable(value = "id") Long userId) {
        Optional<User> user = userService.getUserById(userId);
        return ResponseEntity.ok().body(user);
    }

    @PostMapping("/")
    public User createUser(@Validated @RequestBody User user) {
        return userService.createUser(user);
    }

    @PutMapping("/{id}")
    public ResponseEntity<User> updateUser(@PathVariable(value = "id") Long userId,
                                           @Validated @RequestBody User userDetails)
            throws ConfigDataResourceNotFoundException, ChangeSetPersister.NotFoundException {
        User updatedUser = userService.updateUser(userId, userDetails);
        return ResponseEntity.ok(updatedUser);
    }




}
