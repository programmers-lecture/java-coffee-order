package io.input.information;

import java.math.BigDecimal;
import java.util.List;
import domain.menu.MenuCategory;

public class ChangePriceInformation {
    private static final int CATEGORY_NUMBER = 0;
    private static final int MENU_NUMBER = 1;
    private static final int PRICE = 2;

    private final MenuCategory menuCategory;
    private final int menuNumber;
    private final BigDecimal price;

    public ChangePriceInformation(List<String> information) {
        this.menuCategory = MenuCategory.getMenuCategory(
                Integer.parseInt(information.get(CATEGORY_NUMBER)));
        this.menuNumber = Integer.parseInt(information.get(MENU_NUMBER));
        this.price = new BigDecimal(Integer.parseInt(information.get(PRICE)));
    }

    public MenuCategory getMenuCategory() {
        return menuCategory;
    }

    public int getMenuNumber() {
        return menuNumber;
    }

    public BigDecimal getPrice() {
        return price;
    }

}
