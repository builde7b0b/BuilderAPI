package com.builderAPI.builder.services;

import com.builderAPI.builder.model.User;
import com.builderAPI.builder.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    public Optional<User> getUserById(Long userId){
        return userRepository.findById(userId);
    }

    public User createUser(User user) {
        return userRepository.save(user);
    }

    public User updateUser(Long userId, User userDetails) throws ChangeSetPersister.NotFoundException {
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new ChangeSetPersister.NotFoundException());

        user.setUserName(userDetails.getUserName());
        user.setEmailAddress(userDetails.getEmailAddress());
        user.setPassword(userDetails.getPassword());
        user.setRoles(userDetails.getRoles());

        return userRepository.save(user);
    }



}
