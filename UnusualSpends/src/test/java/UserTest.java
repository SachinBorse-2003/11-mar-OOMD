import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class UserTest {
    @Test
    public void testUserProperties() {
        User user = new User("Baburao", "baburao@example.com");

        assertEquals("Baburao", user.getName());
        assertEquals("baburao@example.com", user.getEmailId());
    }

    @Test
    public void testUserWithEmptyName() {
        assertThrows(IllegalArgumentException.class, () -> new User("", "baburao@example.com"));
    }

    @Test
    public void testUserWithNullName() {
        assertThrows(IllegalArgumentException.class, () -> new User(null, "baburao@example.com"));
    }

    @Test
    public void testUserWithEmptyEmailId() {
        assertThrows(IllegalArgumentException.class, () -> new User("Baburao", ""));
    }

    @Test
    public void testUserWithNullEmailId() {
        assertThrows(IllegalArgumentException.class, () -> new User("Baburao", null));
    }
}
