package com.builderAPI.builder.services;

import com.builderAPI.builder.model.User;
import com.builderAPI.builder.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.config.ConfigDataResourceNotFoundException;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    /**
     * Returns a list of all users in the system.
     * @return List of all users
     */
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    /**
     * Retrives a user by their ID
     *
     * @param userId The ID of the user to retrieve.
     * @return Optional containing the user if found, empty otherwise
     */
    public Optional<User> getUserById(Long userId){
        return userRepository.findById(userId);
    }

    /**
     * Create a new user
     * @param user The user to create
     * @return The Created user
     */
    public User createUser(User user) {
        return userRepository.save(user);
    }

    /**
     * Updates an existing user.
     *
     * @param userId The ID of the user to update.
     * @param userDetails The details to update.
     * @return The updated user.
     * @throws ChangeSetPersister.NotFoundException If the user is not found.
     */
    public User updateUser(Long userId, User userDetails) throws ChangeSetPersister.NotFoundException {
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new ChangeSetPersister.NotFoundException());

        user.setUserName(userDetails.getUserName());
        user.setEmailAddress(userDetails.getEmailAddress());
        user.setPassword(userDetails.getPassword());
        user.setRoles(userDetails.getRoles());

        return userRepository.save(user);
    }

    /**
     * Deletes an existing user
     *
     * @param userId The ID of the user to delete
     * @throws ConfigDataResourceNotFoundException If the user is not found.
     * @throws ChangeSetPersister.NotFoundException If the user is not found.
     */
    public void deleteUser(Long userId) throws ConfigDataResourceNotFoundException, ChangeSetPersister.NotFoundException {
        User user = userRepository.findById(userId).orElseThrow(() -> new ChangeSetPersister.NotFoundException());
    }



}
