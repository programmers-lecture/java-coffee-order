package menu;

import io.output.Output;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Menu {
    private static final int ONE = 1;

    private Map<MenuCategory, List<MenuItem>> menuItems;

    public Menu() {
        this.menuItems = new HashMap<>();
        for (MenuCategory menuCategory : MenuCategory.values()) {
            menuItems.put(menuCategory, new ArrayList<>());
        }
    }

    public void init() {
        MenuItem espresso = new MenuItem(MenuCategory.COFFEE,
                1,
                "에스프레소",
                BigDecimal.valueOf(4000.0));
        MenuItem americano = new MenuItem(MenuCategory.COFFEE,
                1,
                "아메리카노",
                BigDecimal.valueOf(3500.0));
        MenuItem greenTea = new MenuItem(MenuCategory.TEA,
                1,
                "녹차",
                BigDecimal.valueOf(4500.0));
        MenuItem brownie = new MenuItem(MenuCategory.DESSERT,
                1,
                "브라우니",
                BigDecimal.valueOf(5000.0));

        registerMenuItem(espresso);
        registerMenuItem(americano);
        registerMenuItem(greenTea);
        registerMenuItem(brownie);
    }

    public void registerMenuItem(MenuItem menuItem) {
        menuItems.get(menuItem.getMenuCategory()).add(menuItem);
    }

    public void setStock(MenuCategory menuCategory, int menuNumber, int stock) {
        int menuNumberIndex = menuNumber - ONE;
        menuItems.get(menuCategory)
                .get(menuNumberIndex)
                .setStock(stock);
    }

    public void changePrice(MenuCategory menuCategory, int menuNumber, BigDecimal price) {
        int menuNumberIndex = menuNumber - ONE;
        menuItems.get(menuCategory)
                .get(menuNumberIndex)
                .changePrice(price);
    }

    public Map<MenuCategory, List<MenuItem>> getMenuItems() {
        return menuItems;
    }

    public void showMenuItems() {
        Output.printMenuItems(menuItems);
    }
}
