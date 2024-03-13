import java.util.Objects;

public class CreditCard {
    private String cardNumber;
    private User owner;

    public CreditCard(String cardNumber, User owner) {
        if (cardNumber == null || cardNumber.isEmpty()) {
            throw new IllegalArgumentException("Card number cannot be empty");
        }
        if (owner == null) {
            throw new IllegalArgumentException("Owner cannot be null");
        }
        this.cardNumber = cardNumber;
        this.owner = owner;
    }

    public String getCardNumber() {
        return cardNumber;
    }

    public User getOwner() {
        return owner;
    }
}
