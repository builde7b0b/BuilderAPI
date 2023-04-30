package com.builderAPI.builder.model;

import com.builderAPI.builder.repository.RoleRepository;
import com.builderAPI.builder.repository.UserRepository;
import com.builderAPI.builder.repository.UserRoleRepository;
import jakarta.transaction.Transactional;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Arrays;
import java.util.HashSet;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest //used to test applications
@Transactional //useful to ensure that test does not modity the database, start each test clean
public class UserRoleTest {

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private RoleRepository roleRepository;
    @Autowired
    private UserRoleRepository userRoleRepository;
    @Test
    public void testCreateUserRole() {
        User user = new User();
        user.setUserName("John");
        user.setEmailAddress("John@gmail.com");
        user.setPassword("password");
        user.setRoles(new HashSet<>(Arrays.asList(RoleName.ROLE_USER)));

        Role role = new Role(user.getId(), RoleName.ROLE_USER);

        userRepository.save(user);
        roleRepository.save(role);

        UserRole userRole = new UserRole();
        userRole.setUser(user);
        userRole.setRole(role);

        userRoleRepository.save(userRole);

        UserRole savedUserRole = userRoleRepository.findById(userRole.getId()).orElse(null);
        assertNotNull(savedUserRole);
        assertEquals(user, savedUserRole.getUser());
        assertEquals(role, savedUserRole.getRole());
    }
}
