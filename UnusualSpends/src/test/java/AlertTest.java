import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.List;

public class AlertTest {
    @Test
    public void testAlertProperties() {
        User user = new User("Baburao", "baburao@example.com");
        Category groceries = new Category("Groceries");
        List<Category> categories = new ArrayList<>();
        categories.add(groceries);

        Alert alert = new Alert(user, categories, 100.0);

        assertEquals(user, alert.getUser());
        assertEquals(categories, alert.getCategoriesWithUnusualSpend());
        assertEquals(100.0, alert.getTotalUnusualSpend());
    }
}
