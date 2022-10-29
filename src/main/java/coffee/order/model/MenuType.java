package coffee.order.model;

import java.util.Arrays;
import java.util.NoSuchElementException;

public enum MenuType {
    COFFEE("커피", 1),
    TEA("티", 2),
    DESSERT("디저트", 3);

    private final String koreanName;
    private final int menuTypeIndex;

    MenuType(String koreanName, int menuTypeIndex) {
        this.koreanName = koreanName;
        this.menuTypeIndex = menuTypeIndex;
    }

    public static MenuType[] getMenuTypes() {
        return MenuType.values();
    }

    public String getKoreanName() {
        return koreanName;
    }

    public int getMenuTypeIndex() {
        return menuTypeIndex;
    }

    public static MenuType findMenuTypeByIndex(int menuTypeIndex) {
        return Arrays.stream(MenuType.values())
                .filter(menuType -> menuType.getMenuTypeIndex() == menuTypeIndex)
                .findFirst()
                .orElseThrow(NoSuchElementException::new);
    }
}
