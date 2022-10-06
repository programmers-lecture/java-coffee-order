package coffee.order.controller;

import coffee.order.model.MenuType;
import coffee.order.view.MenuChoice;

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

            MenuChoice menuChoice = viewManager.readMenuChoice();
            serviceManager.createNewTransaction(menuChoice);
//            viewManager.confirmOrder();

            // TODO: Coupon Service

            break;
        }
    }
}
