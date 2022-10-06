package coffee.order.repository;

import coffee.order.model.*;

import java.util.ArrayList;
import java.util.HashMap;

public class MenuRepository {
    private final HashMap<MenuType, ArrayList<? super Menu>> menuDatabase;

    public MenuRepository() {
        menuDatabase = new HashMap<>();
        initializeMenuDatabase();
    }

    public void addMenu(Menu menu) {
        // TODO: find type of menu & add menu to Database
        // TODO: refactor: MenuType을 찾는 것을 메서드로 변경.
        if (menu instanceof Coffee) {
            menuDatabase.get(MenuType.COFFEE).add(menu);
        }

        if (menu instanceof Tea) {
            menuDatabase.get(MenuType.TEA).add(menu);
        }

        if (menu instanceof Dessert) {
            menuDatabase.get(MenuType.DESSERT).add(menu);
        }
    }

    private void initializeMenuDatabase() {
        menuDatabase.put(MenuType.COFFEE, new ArrayList<>());
        menuDatabase.put(MenuType.TEA, new ArrayList<>());
        menuDatabase.put(MenuType.DESSERT, new ArrayList<>());
    }

    public HashMap<MenuType, ArrayList<? super Menu>> getMenuDatabase() {
        return menuDatabase;
    }
}
