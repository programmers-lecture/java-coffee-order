package domain.menu;

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
        return Arrays.stream(MenuCategory.values())
                .filter(menuCategory -> menuCategory.getCategoryName().equals(categoryName))
                .findAny()
                .orElseThrow(() -> new IllegalArgumentException(
                        "카테코리 이름에 일치하는 메뉴 카테고리가 없습니다. categoryName : " + categoryName));
    }

    public static MenuCategory getMenuCategory(int categoryNumber) {
        return Arrays.stream(MenuCategory.values())
                .filter(menuCategory -> menuCategory.getCategoryNumber() == categoryNumber)
                .findAny()
                .orElseThrow(() -> new IllegalArgumentException(
                        "카테고리 번호에 일치하는 메뉴 카테고리가 없습니다. categoryNumber : " + categoryNumber));
    }
}
