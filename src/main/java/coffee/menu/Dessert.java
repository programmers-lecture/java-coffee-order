package coffee.menu;

import java.util.ArrayList;
import java.util.List;

public class Dessert {
    public static List<Menu> dessertMenu = new ArrayList<>();

    {
        dessertMenu.add(new Menu("2-1","딸기케잌",  6000));
        dessertMenu.add(new Menu("2-2","초코케잌",  6500));
        dessertMenu.add(new Menu("2-3", "티라미수케잌", 7000));
        dessertMenu.add(new Menu("2-4", "치즈케잌", 7500));
    }

    public static Object findBySerialNumber(String serialNumber) {
        return dessertMenu.stream().filter(s -> s.getSerialNumber().equals(serialNumber));
    }

}
