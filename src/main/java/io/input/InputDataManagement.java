package io.input;

import domain.order.Order;
import domain.order.OrderList;
import io.input.information.ChangePriceInformation;
import io.input.information.MenuItemElement;
import io.input.information.SetStockInformation;
import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;
import domain.menu.Menu;
import domain.menu.MenuCategory;
import domain.menu.MenuItem;
import domain.selection.BaristaSelection;
import domain.selection.UserSelection;

public class InputDataManagement {

    private static final String DELETE = "";
    private static final int MENU_CATEGORY_NUMBER = 0;

    public MenuItem stringToMenuItem(String input) {
        List<String> menuItemElements = stringToMenuItemElements(input);

        int categoryNumber = getCategoryNumber(menuItemElements);
        String categoryName = getCategoryName(menuItemElements);
        int menuNumber = getMenuNumber(menuItemElements, MenuItemElement.MENU_NUMBER.value());
        String menuName = getMenuName(menuItemElements);
        BigDecimal menuPrice = getMenuPrice(menuItemElements);

        validCategoryNumberAndName(categoryNumber, categoryName);
        MenuCategory menuCategory = MenuCategory.getMenuCategory(categoryName);

        return new MenuItem(menuCategory, menuNumber, menuName, menuPrice);
    }

    public UserSelection intToUserSelection(int input) {
        return UserSelection.getUserOption(input);
    }

    public BaristaSelection intToBaristaSelection(int input) {
        return BaristaSelection.getBaristaOption(input);
    }

    public SetStockInformation getInformationForSetStock(String input) {
        List<String> information = Arrays.asList(
                input.replace(SpecialSymbol.HYPHEN.symbol(), SpecialSymbol.COMMA.symbol())
                        .replace(SpecialSymbol.SPACE.symbol(), DELETE)
                        .split(SpecialSymbol.COMMA.symbol())
        );
        return new SetStockInformation(information);
    }

    public ChangePriceInformation getInformationForChangePrice(String input) {
        List<String> information = Arrays.asList(
                input.replace(SpecialSymbol.HYPHEN.symbol(), SpecialSymbol.COMMA.symbol())
                        .replace(SpecialSymbol.SPACE.symbol(), DELETE)
                        .split(SpecialSymbol.COMMA.symbol())
        );

        return new ChangePriceInformation(information);
    }

    private List<String> stringToMenuItemElements(String input) {
        return Arrays.asList(
                input.replace(SpecialSymbol.PERIOD.symbol(), SpecialSymbol.COMMA.symbol())
                        .replace(SpecialSymbol.SPACE.symbol(), DELETE)
                        .replace(SpecialSymbol.HYPHEN.symbol(), SpecialSymbol.COMMA.symbol())
                        .split(SpecialSymbol.COMMA.symbol())
        );
    }

    private int getCategoryNumber(List<String> input) {
        return Integer.parseInt(input.get(MenuItemElement.CATEGORY_NUMBER.value()));
    }

    private String getCategoryName(List<String> input) {
        return input.get(MenuItemElement.CATEGORY_NAME.value());
    }

    private int getMenuNumber(List<String> input, int index) {
        return Integer.parseInt(input.get(index));
    }

    private String getMenuName(List<String> input) {
        return input.get(MenuItemElement.MENU_NAME.value());
    }

    private BigDecimal getMenuPrice(List<String> input) {
        int menuPrice = Integer.parseInt(input.get(MenuItemElement.MENU_PRICE.value()));
        return BigDecimal.valueOf(menuPrice);
    }

    private void validCategoryNumberAndName(int categoryNumber, String categoryName) {
        validCategoryNumber(categoryNumber);
        validCategoryName(categoryName);
        if (MenuCategory.getMenuCategory(categoryName).getCategoryNumber() != categoryNumber) {
            throw new IllegalArgumentException("Category number is not matched with category name");
        }
    }

    private void validCategoryNumber(int categoryNumber) {
        if (Arrays.stream(MenuCategory.values())
                .noneMatch(menuCategory -> menuCategory.getCategoryNumber() == categoryNumber)) {
            throw new IllegalArgumentException("Invalid Category Number : " + categoryNumber);
        }
    }

    private void validCategoryName(String categoryName) {
        MenuCategory.getMenuCategory(categoryName);
    }

    public Order getOrder(String input, Menu menu) {
        List<String> orderElements = stringToOrderElements(input);
        int categoryNumber = getCategoryNumber(orderElements);
        int menuNumber = getMenuNumber(orderElements, MenuNumber.FOR_ORDER.value());
        int count = getOrderCount(orderElements);
        MenuCategory menuCategory = MenuCategory.getMenuCategory(categoryNumber);
        MenuItem menuItem = menu.getMenuItem(menuCategory, menuNumber);
        return new Order(menuItem, count);
    }

    private int getOrderCount(List<String> input) {
        return Integer.parseInt(input.get(MenuItemElement.ORDER_COUNT.value()));
    }

    private List<String> stringToOrderElements(String input) {
        return Arrays.asList(
                input.replace(SpecialSymbol.HYPHEN.symbol(), SpecialSymbol.COMMA.symbol())
                        .replace(SpecialSymbol.SPACE.symbol(), DELETE)
                        .split(SpecialSymbol.COMMA.symbol())
        );
    }

    public Order getOrderForCoupon(String input, OrderList orderList) {
        MenuCategory menuCategory = MenuCategory.getMenuCategory(
                Integer.parseInt(String.valueOf(input.charAt(MENU_CATEGORY_NUMBER))));
        int menuNumber = Integer.parseInt(
                String.valueOf(input.charAt(MenuNumber.FOR_COUPON.value())));
        return orderList.getOrder(menuCategory, menuNumber);
    }
}
