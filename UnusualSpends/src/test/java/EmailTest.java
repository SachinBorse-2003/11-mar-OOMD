import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.time.LocalDateTime;
import java.time.Month;
import java.util.ArrayList;
import java.util.List;

public class EmailTest {
    @Test
    public void testComposeMessageWithoutMocks() {

        User user = new User("Baburao", "baburao@example.com");



        Category travel = new Category("Travel");


        Transaction transaction1 = new Transaction(800.0, travel, LocalDateTime.now().minusMonths(1));
        Transaction transaction2 = new Transaction(1200.0, travel, LocalDateTime.now());

        List<Transaction> transactions = new ArrayList<>();

        transactions.add(transaction1);
        transactions.add(transaction2);


        user.getTransactions().addAll(transactions);

        MonthlySpendingAnalyzer analyzer = new MonthlySpendingAnalyzer();


        String expectedMessage = "Unusual spending of ₹400.0 detected!\n\n" +
                "Hello Baburao!\n\n" +
                "We have detected unusually high spending on your card in these categories:\n\n" +
                "* You spent ₹1200.0 on Travel\n\n" +
                "Thanks,\n" +
                "The Credit Card Company";


        String actualMessage = Email.composeMessage(user, analyzer, Month.MARCH, Month.FEBRUARY);

        assertEquals(expectedMessage, actualMessage);
    }
}
