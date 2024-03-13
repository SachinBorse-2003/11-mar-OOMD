import java.util.List;

public class Alert {
    private User user;
    private List<Category> categoriesWithUnusualSpend;
    private double totalUnusualSpend;

    public Alert(User user, List<Category> categoriesWithUnusualSpend, double totalUnusualSpend) {
        this.user = user;
        this.categoriesWithUnusualSpend = categoriesWithUnusualSpend;
        this.totalUnusualSpend = totalUnusualSpend;
    }

    public User getUser() {
        return user;
    }

    public List<Category> getCategoriesWithUnusualSpend() {
        return categoriesWithUnusualSpend;
    }

    public double getTotalUnusualSpend() {
        return totalUnusualSpend;
    }
}
