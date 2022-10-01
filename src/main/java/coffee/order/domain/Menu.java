package coffee.order.domain;

public class Menu {

    private final Category category;
    private final String name;
    private final String foodCode;
    private int price;

    public Menu(Category category, String name, String foodCode, int price) {
        this.category = category;
        this.name = name;
        this.foodCode = foodCode;
        this.price = price;
    }

    public String getFoodCode() {
        return foodCode;
    }

    public Category getCategory() {
        return category;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return this.foodCode + " " + this.name;
    }

    public int getPrice() {
        return this.price;
    }
}
