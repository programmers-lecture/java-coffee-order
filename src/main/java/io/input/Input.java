package io.input;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import menu.MenuCategory;
import menu.MenuItem;

public class Input {
    private static final String SPACE = " ";
    private static final int FIRST_CATEGORY_NUMBER = 0;
    private static final int CATEGORY_NAME = 1;
    private static final int MENU_NUMBER = 3;
    private static final int MENU_NAME = 4;
    private static final int MENU_PRICE = 5;
    private static final String PERIOD = ".";
    private static final String COMMA = ",";
    private static final String DELETE = "";
    private static final String HYPHEN = "-";

    public static int getChoice() {
        Scanner kb = new Scanner(System.in);
        return kb.nextInt();
    }

    public static MenuItem getMenuItem() {
        Scanner kb = new Scanner(System.in);
        String input = kb.nextLine();
        return stringToMenuItem(input);
    }

    public static String getInformationForSetStock() {
        Scanner kb = new Scanner(System.in);
        return kb.nextLine();
    }

    public static String getInformationForChangePrice() {
        Scanner kb = new Scanner(System.in);
        return kb.nextLine();
    }

    private static MenuItem stringToMenuItem(String input) {
        List<String> menuItemElements = stringToMenuItemElements(input);

        int categoryNumber = getCategoryNumber(menuItemElements);
        String categoryName = getCategoryName(menuItemElements);
        int menuNumber = getMenuNumber(menuItemElements);
        String menuName = getMenuName(menuItemElements);
        BigDecimal menuPrice = getMenuPrice(menuItemElements);

        validCategoryNumberAndName(categoryNumber, categoryName);
        MenuCategory menuCategory = MenuCategory.getMenuCategory(categoryName);

        return new MenuItem(menuCategory, menuNumber, menuName, menuPrice);
    }

    private static List<String> stringToMenuItemElements(String input) {
        return Arrays.asList(
                input.replace(PERIOD, COMMA)
                        .replace(SPACE, DELETE)
                        .replace(HYPHEN, COMMA)
                        .split(COMMA)
        );
    }

    private static int getCategoryNumber(List<String> menuItemElements) {
        return Integer.valueOf(menuItemElements.get(FIRST_CATEGORY_NUMBER));
    }

    private static String getCategoryName(List<String> menuItemElements) {
        return menuItemElements.get(CATEGORY_NAME);
    }

    private static int getMenuNumber(List<String> menuItemElements) {
        return Integer.valueOf(menuItemElements.get(MENU_NUMBER));
    }

    private static String getMenuName(List<String> menuItemElements) {
        return menuItemElements.get(MENU_NAME);
    }

    private static BigDecimal getMenuPrice(List<String> menuItemElements) {
        Integer menuPrice = Integer.valueOf(menuItemElements.get(MENU_PRICE));
        return BigDecimal.valueOf(menuPrice);
    }

    private static void validCategoryNumberAndName(int categoryNumber, String categoryName) {
        validCategoryNumber(categoryNumber);
        validCategoryName(categoryName);
        if (MenuCategory.getMenuCategory(categoryName).getCategoryNumber() != categoryNumber) {
            throw new IllegalArgumentException("Category number is not matched with category name");
        }
    }

    private static void validCategoryNumber(int categoryNumber) {
        if (Arrays.asList(MenuCategory.values())
                .stream()
                .noneMatch(menuCategory -> menuCategory.getCategoryNumber() == categoryNumber)) {
            throw new IllegalArgumentException("Invalid Category Number : " + categoryNumber);
        }
    }

    private static void validCategoryName(String categoryName) {
        MenuCategory.getMenuCategory(categoryName);
    }
}
