package com.builderAPI.builder;

import com.builderAPI.builder.Model.User;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

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
		user.setRoles("ROLE_USER");
		assertNotNull(user.getId());
		assertEquals("John Doe", user.getUserName());
		assertEquals("john.doe@example.com", user.getEmailAddress());
		assertEquals("password", user.getPassword());
		assertEquals("ROLE_USER", user.getRoles());
	}



}
