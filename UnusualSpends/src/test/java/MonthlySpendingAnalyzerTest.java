import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.time.LocalDateTime;
import java.time.Month;
import java.util.ArrayList;
import java.util.List;

public class MonthlySpendingAnalyzerTest {
    @Test
    public void testCompareMonthlySpending() {
        User user = new User("Baburao", "baburao@example.com");
        Category groceries = new Category("Groceries");
        Category travel = new Category("Travel");

        Transaction transaction1 = new Transaction(100.0, groceries, LocalDateTime.now().minusMonths(1));
        Transaction transaction2 = new Transaction(150.0, groceries, LocalDateTime.now());
        Transaction transaction3 = new Transaction(800.0, travel, LocalDateTime.now().minusMonths(1));
        Transaction transaction4 = new Transaction(1200.0, travel, LocalDateTime.now());

        user.getTransactions().add(transaction1);
        user.getTransactions().add(transaction2);
        user.getTransactions().add(transaction3);
        user.getTransactions().add(transaction4);

        MonthlySpendingAnalyzer analyzer = new MonthlySpendingAnalyzer();
        Alert alert = analyzer.compareMonthlySpending(user, Month.MARCH, Month.FEBRUARY);

        assertEquals(user, alert.getUser());
        assertEquals(2, alert.getCategoriesWithUnusualSpend().size());
        assertEquals(450.0, alert.getTotalUnusualSpend());
    }

    @Test
    public void testCompareMonthlySpendingWithNullUser() {
        MonthlySpendingAnalyzer analyzer = new MonthlySpendingAnalyzer();
        assertThrows(IllegalArgumentException.class, () -> analyzer.compareMonthlySpending(null, Month.MARCH, Month.FEBRUARY));
    }
}
