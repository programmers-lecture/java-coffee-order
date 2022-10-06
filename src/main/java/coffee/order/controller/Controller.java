package coffee.order.controller;

import coffee.order.model.MenuType;

import java.util.HashMap;

public class Controller {
    private final ViewManager viewManager;
    private final ServiceManager serviceManager;

    public Controller() {
        viewManager = new ViewManager();
        serviceManager = new ServiceManager();
    }

    public void runCafeApplication() {
        while (true) {
            viewManager.greeting();
            serviceManager.initializeMenu();
            viewManager.showMenu(MenuType.getMenuTypes(), serviceManager.getMenu());

            HashMap<String, Integer> menuChoice = viewManager.readMenuChoice();
//            ServiceManager.createNewTransaction();
//            viewManager.confirmOrder();

            // TODO: Coupon Service

            break;
        }
    }
}
