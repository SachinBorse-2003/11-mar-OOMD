import java.time.LocalDateTime;

public class Transaction {
    private double amount;
    private Category category;
    private LocalDateTime timestamp;

    public Transaction(double amount, Category category, LocalDateTime timestamp) {
        if (amount < 0) {
            throw new IllegalArgumentException("Amount cannot be negative");
        }
        if (category == null) {
            throw new IllegalArgumentException("Category cannot be null");
        }
        if (timestamp == null) {
            throw new IllegalArgumentException("Timestamp cannot be null");
        }
        this.amount = amount;
        this.category = category;
        this.timestamp = timestamp;
    }

    public double getAmount() {
        return amount;
    }

    public Category getCategory() {
        return category;
    }

    public LocalDateTime getTimestamp() {
        return timestamp;
    }
}
