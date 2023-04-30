package com.builderAPI.builder.security;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static jdk.internal.jimage.ImageReaderFactory.get;
import static org.hamcrest.Matchers.containsString;
import static org.postgresql.Driver.user;
import static org.springframework.test.web.client.match.MockRestRequestMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment =  SpringBootTest.WebEnvironment.RANDOM_PORT)
@AutoConfigureMockMvc // allows us to use MockMvc to perform HTTP requests against our application.
public class SecurityConfigTest {

    @Autowired
    private MockMvc mockMvc;
    @Test

    public void testAuthenticatedUserAccess() throws Exception {
        mockMvc.perform(get("/secured-resource")
                //sets up an authenticated user with the username "user", password "password", and role "USER".
                .with(user("user").password("password").roles("USER")))
                .andExpect(status().isOk())
                .andExpect(content().string(containsString("Access granted to user")));
        // assert the response status code and body, respectively.
    }

    @Test
    public void testUnauthorizedUserAccess() throws Exception {
        mockMvc.perform(get("/secured-resource"))
                .andExpect(status().isUnauthorized());
    }


}
