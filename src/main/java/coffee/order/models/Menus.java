package coffee.order.models;

import coffee.order.enums.MenuCategory;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Menus {
    private final List<Menu> menus;

    public Menus() {
        menus = new ArrayList<>();
        menus.add(new Menu(MenuCategory.COFFEE, "1-1", "에스프레소", 2000));
        menus.add(new Menu(MenuCategory.COFFEE, "1-2", "아메리카노", 3000));
        menus.add(new Menu(MenuCategory.COFFEE, "1-3", "콜드블루", 4000));
        menus.add(new Menu(MenuCategory.COFFEE, "1-4", "카페라떼", 0));
        menus.add(new Menu(MenuCategory.TEA, "2-1", "그린티", 0));
        menus.add(new Menu(MenuCategory.DESSERT, "3-1", "케잌", 0));
    }

    public List<Menu> getMenusByCategory(MenuCategory category) {
        return menus.stream()
                .filter(menu -> menu.isFoodCategory(category))
                .collect(Collectors.toList());
    }

    public Menu getMenuByNumber(String number) {
        return menus.stream()
                .filter(menu -> menu.getNumber().equals(number))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("선택한 항목에 해당하는 메뉴가 없습니다."));
    }
}
