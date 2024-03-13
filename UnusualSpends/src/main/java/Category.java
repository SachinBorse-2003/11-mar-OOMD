public class Category {
    private String name;

    public Category(String name) {
        if (name == null || name.isEmpty()) {
            throw new IllegalArgumentException("Category name cannot be null or empty");
        }
        this.name = name;
    }

    public String getName() {

        return name;
    }
}
