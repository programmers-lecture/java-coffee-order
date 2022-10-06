package coffee.order.enums;

public enum FoodCategory {
    COFFEE("커피", 1),
    TEA("티", 2),
    DESSERT("디저트", 3);

    private final String category;
    private final int number;

    FoodCategory(String category, int number) {
        this.category = category;
        this.number = number;
    }

    public String getCategory() {
        return category;
    }

    public int getNumber() {
        return number;
    }
}
