package coffee.order.domain;

import java.util.*;
import java.util.stream.Collectors;

public class Menus {
    public final List<Menu> menus = new ArrayList<>();

    {
        menus.add(new Menu(Category.COFFEE, "에스프레소", "1-1", 2000));
        menus.add(new Menu(Category.COFFEE, "아메리카노", "1-2", 3000));
        menus.add(new Menu(Category.COFFEE, "콜드블루", "1-3", 4000));
        menus.add(new Menu(Category.COFFEE, "카페라떼", "1-4", 0));
        menus.add(new Menu(Category.TEA, "그린티", "2-1", 0));
        menus.add(new Menu(Category.DESSERT, "케잌", "3-1", 0));
    }


    public void sortMenus() {
        Collections.sort(menus, new Comparator<Menu>() {
            @Override
            public int compare(Menu o1, Menu o2) {
                return o1.getFoodCode().compareTo(o2.getFoodCode());
            }
        });
    }

    public String getListOf(Category category) {
        return menus.stream().filter(menu -> menu.getCategory() == category)
                .map(menu -> menu.getFoodCode() + " " + menu.getName())
                .collect(Collectors.joining("\n"));
    }

    public Menu findByCode(String foodCode) {
        return menus.stream().filter(i -> i.getFoodCode().equals(foodCode))
                .findFirst()
                .get();
    }
}
