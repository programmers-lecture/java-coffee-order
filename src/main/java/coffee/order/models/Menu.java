package coffee.order.models;

import coffee.order.enums.MenuCategory;

public class Menu {
    private final MenuCategory category;
    private final String number;
    private final String name;
    private final MenuPrice price;

    public Menu(MenuCategory category, String number, String name, int price) {
        this.category = category;
        this.number = number;
        this.name = name;
        this.price = new MenuPrice(price);
    }

    public boolean isFoodCategory(MenuCategory category) {
        return this.category.equals(category);
    }

    public String getNumber() {
        return number;
    }

    public String getName() {
        return name;
    }

    public int getPrice() {
        return price.getPrice();
    }
}
