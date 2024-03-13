import java.time.Month;

public class Email {
    public static String composeMessage(User user, MonthlySpendingAnalyzer analyzer, Month currentMonth, Month previousMonth) {
        Alert alert = analyzer.compareMonthlySpending(user, currentMonth, previousMonth);

        StringBuilder message = new StringBuilder();
        message.append("Unusual spending of ₹").append(alert.getTotalUnusualSpend()).append(" detected!\n\n");
        message.append("Hello ").append(user.getName()).append("!\n\n");
        message.append("We have detected unusually high spending on your card in these categories:\n\n");

        for (Category category : alert.getCategoriesWithUnusualSpend()) {
            message.append("* You spent ₹").append(getAmountInMonth(user, category ,currentMonth)).append(" on ").append(category.getName()).append("\n");
        }

        message.append("\nThanks,\n");
        message.append("The Credit Card Company");

        return message.toString();
    }

    private static double getAmountInMonth(User user, Category category, Month month) {
        double totalAmount = 0.0;

        for (Transaction transaction : user.getTransactions()) {
            if (transaction.getTimestamp().getMonth() == month && transaction.getCategory().equals(category)) {
                totalAmount = transaction.getAmount();
            }
        }

        return totalAmount;
    }
}
