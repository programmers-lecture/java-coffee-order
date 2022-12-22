package coffee.menu;

import java.util.Arrays;
import java.util.HashMap;

public class Category {
    Coffee coffee = new Coffee();
    Tea tea = new Tea();
    Dessert dessert = new Dessert();

    private final HashMap<String,Class> menus = new HashMap<>();
    {
        menus.put("1", coffee.getClass());
        menus.put("2", tea.getClass());
        menus.put("3",dessert.getClass());
    }


}
