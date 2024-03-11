import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class UserTest {
    @Test
    public void testUserProperties() {
        User user = new User("Baburao", "baburao@example.com");

        assertEquals("Baburao", user.getName());
        assertEquals("baburao@example.com", user.getEmailId());
    }
}
