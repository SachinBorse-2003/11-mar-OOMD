import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class UserTest {

    @Test
    public void shouldThrowExceptionForEmptyOrNullName() {
        assertThrows(IllegalArgumentException.class, () -> new User("", "baburao@example.com"));
        assertThrows(IllegalArgumentException.class, () -> new User(null, "baburao@example.com"));
    }

    @Test
    public void shouldThrowExceptionForInvalidName() {
        assertThrows(IllegalArgumentException.class, () -> new User("123", "baburao@example.com"));
        assertThrows(IllegalArgumentException.class, () -> new User("Babu@rao", "baburao@example.com"));
    }

    @Test
    public void shouldThrowExceptionForEmptyOrNullEmail() {
        assertThrows(IllegalArgumentException.class, () -> new User("Baburao", ""));
        assertThrows(IllegalArgumentException.class, () -> new User("Baburao", null));
    }

    @Test
    public void shouldThrowExceptionForInvalidEmailFormat() {
        assertThrows(IllegalArgumentException.class, () -> new User("Baburao", "invalid_email"));
        assertThrows(IllegalArgumentException.class, () -> new User("Baburao", "baburao@example"));
        assertThrows(IllegalArgumentException.class, () -> new User("Baburao", "baburao@example."));
    }

    @Test
    public void shouldReturnCorrectName() {
        User user = new User("Baburao", "baburao@example.com");
        assertEquals("Baburao", user.getName());
    }

    @Test
    public void shouldReturnCorrectEmail() {
        User user = new User("Baburao", "baburao@example.com");
        assertEquals("baburao@example.com", user.getEmailId());
    }
}
