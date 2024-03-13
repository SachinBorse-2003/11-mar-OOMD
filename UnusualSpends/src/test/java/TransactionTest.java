import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import java.time.LocalDateTime;

public class TransactionTest {
    @Test
    public void testTransactionProperties() {
        Category category = new Category("Groceries");
        LocalDateTime timestamp = LocalDateTime.now();
        Transaction transaction = new Transaction(100.0, category, timestamp);

        assertEquals(100.0, transaction.getAmount());
        assertEquals(category, transaction.getCategory());
        assertEquals(timestamp, transaction.getTimestamp());
    }

    @Test
    public void testTransactionWithNegativeAmount() {
        Category category = new Category("Groceries");
        assertThrows(IllegalArgumentException.class, () -> new Transaction(-100.0, category, LocalDateTime.now()));
    }

    @Test
    public void testTransactionWithNullCategory() {
        assertThrows(IllegalArgumentException.class, () -> new Transaction(100.0, null, LocalDateTime.now()));
    }

    @Test
    public void testTransactionWithNullTimestamp() {
        Category category = new Category("Groceries");
        assertThrows(IllegalArgumentException.class, () -> new Transaction(100.0, category, null));
    }
}
