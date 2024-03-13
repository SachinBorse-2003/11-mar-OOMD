import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class CategoryTest {
    @Test
    public void testCategoryProperties() {
        Category category = new Category("Groceries");

        assertEquals("Groceries", category.getName());
    }

    @Test
    public void testCategoryWithEmptyName() {
        assertThrows(IllegalArgumentException.class, () -> new Category(""));
    }

    @Test
    public void testCategoryWithNullName() {
        assertThrows(IllegalArgumentException.class, () -> new Category(null));
    }
}
