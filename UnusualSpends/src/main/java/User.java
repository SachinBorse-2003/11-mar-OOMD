import java.util.ArrayList;
import java.util.List;

public class User {
    private String name;
    private String emailId;
    private List<Transaction> transactions;

    public User(String name, String emailId) {
        if (name == null || name.isEmpty()) {
            throw new IllegalArgumentException("Name cannot be null or empty");
        }
        if (emailId == null || emailId.isEmpty()) {
            throw new IllegalArgumentException("Email ID cannot be null or empty");
        }
        this.name = name;
        this.emailId = emailId;
        this.transactions = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public String getEmailId() {
        return emailId;
    }

    public List<Transaction> getTransactions() {
        return transactions;
    }
}
