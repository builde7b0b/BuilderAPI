package com.builderAPI.builder;

import com.builderAPI.builder.model.Role;
import com.builderAPI.builder.model.User;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.HashSet;
import java.util.Set;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.springframework.test.util.AssertionErrors.assertTrue;

@SpringBootTest
class BuilderApplicationTests {



	@Test
	void contextLoads() {
	}

	@org.junit.Test
	public void testCreateUser() {
		User user = new User();
		user.setUserName("John Doe");
		user.setEmailAddress("john.doe@example.com");
		user.setPassword("password");

		// Create a set of roles
		Set<Role> roles = new HashSet<>();
		roles.add(new Role());
		user.setRoles(roles);

		// Test user properties
		assertNotNull(user.getId());
		assertEquals("John Doe", user.getUserName());
		assertEquals("john.doe@example.com", user.getEmailAddress());
		assertEquals("password", user.getPassword());
		assertEquals(1, user.getRoles().size());

	}


}
