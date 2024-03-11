public class CreditCard {
    private String cardNumber;
    private User owner;

    public CreditCard(String cardNumber, User owner) {
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
