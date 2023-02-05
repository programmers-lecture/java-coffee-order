package menu;

import java.math.BigDecimal;

public class MenuItem extends Menu {
    private static final int INITIAL_STOCK = 10;
    private MenuCategory menuCategory;
    private String menuName;
    private BigDecimal price;
    private int menuNumber;
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

    public void setStock(int stock) {
        this.stock = stock;
    }

    public void changePrice(BigDecimal price) {
        this.price = price;
    }

    public BigDecimal calculateOrderPrice(int count) {
        return price.multiply(BigDecimal.valueOf(count));
    }

    @Override
    public String toString() {
        return menuCategory.getCategoryNumber() + "-" + menuNumber + " " + menuName;
    }
}
