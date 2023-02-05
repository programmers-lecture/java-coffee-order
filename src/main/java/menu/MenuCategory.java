package menu;

import java.util.Arrays;

public enum MenuCategory {
    COFFEE("커피", 1),
    TEA("티", 2),
    DESSERT("디저트", 3);

    private final int categoryNumber;
    private final String categoryName;

    MenuCategory(String categoryName, int categoryNumber) {
        this.categoryName = categoryName;
        this.categoryNumber = categoryNumber;
    }

    public int getCategoryNumber() {
        return categoryNumber;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public static MenuCategory getMenuCategory(String categoryName) {
        return Arrays.asList(MenuCategory.values()).stream()
                .filter(menuCategory -> menuCategory.getCategoryName().equals(categoryName))
                .findAny()
                .get();
    }

    public static MenuCategory getMenuCategory(int categoryNumber) {
        return Arrays.asList(MenuCategory.values()).stream()
                .filter(menuCategory -> menuCategory.getCategoryNumber() == categoryNumber)
                .findAny()
                .get();
    }
}
