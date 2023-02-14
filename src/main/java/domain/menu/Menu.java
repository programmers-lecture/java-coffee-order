package domain.menu;

import domain.order.OrderList;
import io.input.information.ChangePriceInformation;
import io.input.information.SetStockInformation;
import io.output.Output;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Menu {
    private static final int ONE = 1;

    private final Map<MenuCategory, List<MenuItem>> menuItems;

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
                BigDecimal.valueOf(4000));
        MenuItem americano = new MenuItem(MenuCategory.COFFEE,
                2,
                "아메리카노",
                BigDecimal.valueOf(3500));
        MenuItem greenTea = new MenuItem(MenuCategory.TEA,
                1,
                "녹차",
                BigDecimal.valueOf(4500));
        MenuItem brownie = new MenuItem(MenuCategory.DESSERT,
                1,
                "브라우니",
                BigDecimal.valueOf(5000));

        registerMenuItem(espresso);
        registerMenuItem(americano);
        registerMenuItem(greenTea);
        registerMenuItem(brownie);
    }

    public void registerMenuItem(MenuItem menuItem) {
        menuItems.get(menuItem.getMenuCategory()).add(menuItem);
    }

    public void setStock(SetStockInformation setStockInformation) {
        MenuCategory menuCategory = setStockInformation.getMenuCategory();
        int menuNumberIndex = setStockInformation.getMenuNumber() - ONE;
        int stock = setStockInformation.getStock();

        menuItems.get(menuCategory)
                .get(menuNumberIndex)
                .setStock(stock);
    }

    public void changePrice(ChangePriceInformation changePriceInformation) {
        MenuCategory menuCategory = changePriceInformation.getMenuCategory();
        int menuNumberIndex = changePriceInformation.getMenuNumber() - ONE;
        BigDecimal price = changePriceInformation.getPrice();

        menuItems.get(menuCategory)
                .get(menuNumberIndex)
                .changePrice(price);
    }

    public Map<MenuCategory, List<MenuItem>> getMenuItems() {
        return Collections.unmodifiableMap(menuItems);
    }

    public void showStock() {
        Output.printMenuStock(Collections.unmodifiableMap(menuItems));
    }

    public void showPrice() {
        Output.printMenuPrice(Collections.unmodifiableMap(menuItems));
    }

    public void showMenu() {
        Output.printMenu(Collections.unmodifiableMap(menuItems));
    }

    public MenuItem getMenuItem(MenuCategory menuCategory, int menuNumber) {
        int menuNumberIndex = menuNumber - ONE;
        return menuItems.get(menuCategory).get(menuNumberIndex);
    }

    public void reduceStock(OrderList orderList) {
        orderList.getOrders().forEach(order ->
                menuItems.get(order.getMenuItem().getMenuCategory())
                        .get(order.getMenuItem().getMenuNumber() - ONE)
                        .reduceStock(order.getCount())
        );
    }
}
