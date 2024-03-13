import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class CreditCardTest {
    @Test
    public void testCreditCardProperties() {
        User user = new User("Baburao", "baburao@example.com");
        CreditCard creditCard = new CreditCard("1234-5678-9012-3456", user);

        assertEquals("1234-5678-9012-3456", creditCard.getCardNumber());
        assertEquals(user, creditCard.getOwner());
    }

    @Test
    public void testCreditCardWithEmptyCardNumber() {
        User user = new User("Baburao", "baburao@example.com");
        assertThrows(IllegalArgumentException.class, () -> new CreditCard("", user));
    }

    @Test
    public void testCreditCardWithNullOwner() {
        assertThrows(IllegalArgumentException.class, () -> new CreditCard("1234-5678-9012-3456", null));
    }
}
