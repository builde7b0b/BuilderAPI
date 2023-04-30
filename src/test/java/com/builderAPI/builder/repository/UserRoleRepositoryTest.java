package com.builderAPI.builder.repository;
import com.builderAPI.builder.model.User;
import com.builderAPI.builder.model.UserRole;
import org.junit.Test;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import static org.springframework.test.util.AssertionErrors.assertEquals;
import static org.springframework.test.util.AssertionErrors.assertNotNull;

@DataJpaTest
public class UserRoleRepositoryTest {
    private UserRoleRepository userRoleRepository;


    @Test
    public void testSaveUserRole(){
        User user = new User();
        user.setUserName("John");
        user.setEmailAddress("john");
        user.setPassword("password");
        user.setRoles(New HashSet<>(Arrays.asList(Role.ROLE_USER)));

        userRepository.save(user);

        UserRole userRole = new UserRole();
        userRole.setUser(user);
        userRole.setRole(Role.ROLE_USER);

        userRoleRepository.save(userRole);

        UserRole savedUserRole = userRoleRepository.findById(userRole.getId())
                .orElse(null);
        assertNotNull(savedUserRole);
        assertEquals(user, savedUserRole.getUser());
        assertEquals(Role.ROLE_USER, savedUserRole.getRole());
    }
}
