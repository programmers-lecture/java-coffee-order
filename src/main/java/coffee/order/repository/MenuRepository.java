package coffee.order.repository;

import coffee.order.model.*;

import java.util.*;
import java.util.stream.Collectors;

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

    public String findMenuName(MenuType menuType, int menuName) {
        ArrayList<? super Menu> menus = menuDatabase.get(menuType);
        return menus.get(menuName - 1).toString();
    }

    public int findMenuPrice(MenuType menuType, String menuName) {
        ArrayList<? super Menu> menus = menuDatabase.get(menuType);

        // TODO: 다운캐스팅할 때, 다운캐스팅 하는 클래스를 매개변수로 지정하는 방법?
        if (menuType.equals(MenuType.COFFEE)) {
            List<Coffee> distinguishedMenus = menus.stream()
                    .map(menu -> (Coffee) menu)
                    .collect(Collectors.toList());
            return getPrice(menuName, distinguishedMenus);
        }

        if (menuType.equals(MenuType.TEA)) {
            List<Tea> distinguishedMenus = menus.stream()
                    .map(menu -> (Tea) menu)
                    .collect(Collectors.toList());
            return getPrice(menuName, distinguishedMenus);
        }

        if (menuType.equals(MenuType.DESSERT)) {
            List<Dessert> distinguishedMenus = menus.stream()
                    .map(menu -> (Dessert) menu)
                    .collect(Collectors.toList());
            return getPrice(menuName, distinguishedMenus);
        }

        return 0;
    }

    private int getPrice(String menuName, List<? extends Menu> menus) {
        return menus.stream()
                .filter(menu -> menu.toString().equals(menuName))
                .findFirst().get().getPrice();
    }
}
