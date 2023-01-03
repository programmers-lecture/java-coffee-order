package coffee.order.domain.meals;

public enum Category {
    COFFEE(1,"커피"),
    TEA(2,"차"),
    DESSERT(1,"디저트");

    private final int CategoryNumber;
    private final String category;
    Category(int categoryNumber, String category) {
        CategoryNumber = categoryNumber;
        this.category = category;
    }

    public int getCategoryNumber() {
        return CategoryNumber;
    }

    public String getCategory() {
        return category;
    }



}
