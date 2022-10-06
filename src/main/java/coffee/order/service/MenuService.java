package coffee.order.service;

import coffee.order.repository.MenuRepository;

public class MenuService {
    private final MenuRepository menuRepository;

    public MenuService() {
        menuRepository = new MenuRepository();
    }

    public void initializeMenu() {
        MenuInitializer menuInitializer = new MenuInitializer();
        menuInitializer.initializeMenu(menuRepository);
    }
}
