import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

public class User {
    private String name;
    private String emailId;
    private List<Transaction> transactions;

    public User(String name, String emailId) {
        validateName(name);
        validateEmail(emailId);
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

    private void validateName(String name) {
        if (name == null || name.isEmpty()) {
            throw new IllegalArgumentException("Name cannot be null or empty");
        }
        if (!Pattern.matches("^[a-zA-Z]+$", name)) {
            throw new IllegalArgumentException("Name can only contain alphabets");
        }
    }

    private void validateEmail(String emailId) {
        if (emailId == null || emailId.isEmpty()) {
            throw new IllegalArgumentException("Email ID cannot be null or empty");
        }
        if (!Pattern.matches("^[a-zA-Z0-9_+&*-]+(?:\\.[a-zA-Z0-9_+&*-]+)*@(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,7}$",emailId)) {
            throw new IllegalArgumentException("Invalid email address format");
        }
    }


}
