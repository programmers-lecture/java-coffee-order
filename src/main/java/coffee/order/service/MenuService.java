package coffee.order.service;

import coffee.order.model.Menu;
import coffee.order.model.MenuType;
import coffee.order.repository.MenuRepository;

import java.util.ArrayList;
import java.util.HashMap;

public class MenuService {
    private final MenuRepository menuRepository;

    public MenuService() {
        menuRepository = new MenuRepository();
    }

    public void initializeMenu() {
        MenuInitializer menuInitializer = new MenuInitializer();
        menuInitializer.initializeMenu(menuRepository);
    }

    public HashMap<MenuType, ArrayList<? super Menu>> getMenu() {
        return menuRepository.getMenuDatabase();
    }
}
