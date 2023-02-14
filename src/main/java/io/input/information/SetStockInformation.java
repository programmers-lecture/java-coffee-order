package io.input.information;

import java.util.List;
import domain.menu.MenuCategory;

public class SetStockInformation {
    private static final int CATEGORY_NUMBER = 0;
    private static final int MENU_NUMBER = 1;
    private static final int STOCK = 2;

    private final MenuCategory menuCategory;
    private final int menuNumber;
    private final int stock;

    public SetStockInformation(List<String> information) {
        this.menuCategory = MenuCategory.getMenuCategory(
                Integer.parseInt(information.get(CATEGORY_NUMBER)));
        this.menuNumber = Integer.parseInt(information.get(MENU_NUMBER));
        this.stock = Integer.parseInt(information.get(STOCK));
    }

    public MenuCategory getMenuCategory() {
        return menuCategory;
    }

    public int getMenuNumber() {
        return menuNumber;
    }

    public int getStock() {
        return stock;
    }
}
