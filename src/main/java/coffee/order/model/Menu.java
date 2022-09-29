package coffee.order.model;

import java.util.HashMap;
import java.util.Map;

public class Menu {
    private final Map<String, Integer> menu;

    public Menu() {
        menu = new HashMap<>();
    }

    public void createDefaultMenu() {
        menu.put("에스프레소", 2000);
        menu.put("아메리카노", 3000);
        menu.put("콜드브루", 4000);
        menu.put("카페라떼", 5000);
    }
}
