package coffee.order.domain;

public enum Category {
    COFFEE(1, "커피"),
    TEA(2, "티"),
    DESSERT(3, "디저트");

    private final int categoryCode;
    private final String categoryName;

    Category(int categoryCode, String categoryName) {
        this.categoryCode = categoryCode;
        this.categoryName = categoryName;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public int getCategoryCode() {
        return categoryCode;
    }

    public String getCodeAndName() {
        return categoryCode + ". " + categoryName + "\n";
    }
}
