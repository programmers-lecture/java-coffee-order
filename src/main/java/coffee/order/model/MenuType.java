package coffee.order.model;

import java.util.Arrays;
import java.util.NoSuchElementException;

public enum MenuType {
    COFFEE("커피", 1),
    TEA("티", 2),
    DESSERT("디저트", 3);

    private final String koreanName;
    private final int order;

    MenuType(String koreanName, int order) {
        this.koreanName = koreanName;
        this.order = order;
    }

    public static MenuType[] getMenuTypes() {
        return MenuType.values();
    }

    public String getKoreanName() {
        return koreanName;
    }

    public int getOrder() {
        return order;
    }

    public static MenuType findMenuType(int order) {
        return Arrays.stream(MenuType.values())
                .filter(menuType -> menuType.getOrder() == order)
                .findAny()
                .orElseThrow(NoSuchElementException::new);
    }
}
