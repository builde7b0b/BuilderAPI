package com.builderAPI.builder.security;

import org.junit.runner.RunWith;
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
@AutoConfigureMockMvc
public class SecurityConfigTest {

    private MockMvc mockMvc;

    public void testAuthenticatedUserAccess() throws Exception {
        mockMvc.perform(get("/secured-resource")
                .with(user("user").password("password").roles("USER")))
                .andExpect(status().isOk())
                .andExpect(content().string(containsString("Access granted to user")));
    }

    
}
