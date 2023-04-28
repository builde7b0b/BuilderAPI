import com.builderAPI.builder.model.User;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

public class BuilderTest {

    @Test
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
