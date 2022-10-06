package coffee.order.models;

import coffee.order.enums.FoodCategory;

public class Food {
    private FoodCategory category;
    private String number;
    private String name;
    private int price;

    public Food(FoodCategory category, String number, String name, int price) {
        this.category = category;
        this.number = number;
        this.name = name;
        if(price < 0)
            throw new IllegalArgumentException("가격은 음수가 될 수 없습니다.");
        this.price = price;
    }

    public boolean isFoodCategory(FoodCategory category) {
        return this.category.equals(category);
    }

    public String getNumber() {
        return number;
    }

    public String getName() {
        return name;
    }

    public int getPrice() {
        return price;
    }
}
