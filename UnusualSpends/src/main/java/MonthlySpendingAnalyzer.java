import java.time.Month;
import java.util.ArrayList;
import java.util.List;

public class MonthlySpendingAnalyzer {
    public Alert compareMonthlySpending(User user, Month currentMonth, Month previousMonth) {
        if (user == null) {
            throw new IllegalArgumentException("User cannot be null");
        }

        List<Category> categoriesWithUnusualSpend = new ArrayList<>();
        double totalUnusualSpend = 0.0;

        List<Transaction> transactions = user.getTransactions();
        for (int i = 0; i < transactions.size(); i++) {
            Transaction transaction = transactions.get(i);
            if (transaction.getTimestamp().getMonth() == currentMonth) {
                double previousMonthAmount = getPreviousMonthAmount(user, transaction.getCategory(), previousMonth);
                double currentMonthAmount = getAmountInMonth(user, transaction.getCategory(), currentMonth);

                if (currentMonthAmount >= 1.5 * previousMonthAmount) {
                    categoriesWithUnusualSpend.add(transaction.getCategory());
                    totalUnusualSpend += currentMonthAmount - previousMonthAmount;
                }
            }
        }

        return new Alert(user, categoriesWithUnusualSpend, totalUnusualSpend);
    }

    private double getPreviousMonthAmount(User user, Category category, Month previousMonth) {
        return getAmountInMonth(user, category, previousMonth);
    }

    private double getAmountInMonth(User user, Category category, Month month) {
        double totalAmount = 0.0;

        for (Transaction transaction : user.getTransactions()) {
            if (transaction.getTimestamp().getMonth() == month && transaction.getCategory().equals(category)) {
                totalAmount += transaction.getAmount();
            }
        }

        return totalAmount;
    }
}
