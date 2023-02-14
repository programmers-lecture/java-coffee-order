package domain.menu;

import java.math.BigDecimal;

public class MenuItem {
    private static final int INITIAL_STOCK = 10;
    private final MenuCategory menuCategory;
    private final int menuNumber;
    private final String menuName;
    private BigDecimal price;
    private int stock;

    public MenuItem(MenuCategory menuCategory, int menuNumber, String menuName, BigDecimal price) {
        this.menuCategory = menuCategory;
        this.menuNumber = menuNumber;
        this.menuName = menuName;
        this.price = price;
        this.stock = INITIAL_STOCK;
    }

    public MenuCategory getMenuCategory() {
        return menuCategory;
    }

    public int getStock() {
        return stock;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public int getMenuNumber() {
        return menuNumber;
    }

    public String getMenuName() {
        return menuName;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public void changePrice(BigDecimal price) {
        this.price = price;
    }

    public BigDecimal calculateOrderPrice(int count) {
        return price.multiply(BigDecimal.valueOf(count));
    }

    public void reduceStock(int count) {
        stock -= count;
    }
}
