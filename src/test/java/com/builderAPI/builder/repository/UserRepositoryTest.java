package com.builderAPI.builder.repository;

import com.builderAPI.builder.model.User;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@DataJpaTest
public class UserRepositoryTest {

    @Autowired
    private UserRepository userRepository;

    @Test
    public void testSaveUser() {
        User user = new User();
        user.setUserName("John Doe");
        user.setEmailAddress("john.doe@example.com");
        user.setPassword("password");
        user.setRoles("ROLE_USER");

        userRepository.save(user);

        User savedUser = userRepository.findById(user.getId()).orElse(null);
        assertNotNull(savedUser);
        assertEquals("John Doe", savedUser.getUserName());
        assertEquals("john.doe@example.com", savedUser.getEmailAddress());
        assertEquals("password", savedUser.getPassword());
        assertEquals("ROLE_USER", savedUser.getRoles());
    }

    @Test
    public void testFindAllUsers() {
        User user1 = new User();
        user1.setUserName("John Doe");
        user1.setEmailAddress("john.doe@example.com");
        user1.setPassword("password");
        user1.setRoles("ROLE_USER");

        User user2 = new User();
        user2.setUserName("Jane Doe");
        user2.setEmailAddress("jane.doe@example.com");
        user2.setPassword("password");
        user2.setRoles("ROLE_USER");

        userRepository.saveAll(Arrays.asList(user1, user2));

        List<User> userList = userRepository.findAll();
        assertNotNull(userList);
        assertEquals(2, userList.size());
    }

    // Add more test methods for other CRUD operations (e.g., findById(), deleteById(), etc.) here
}
