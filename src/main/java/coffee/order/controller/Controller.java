package coffee.order.controller;

import coffee.order.model.MenuType;
import coffee.order.view.Order;

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

            Order order = viewManager.readMenuChoice();
            serviceManager.createNewTransaction(order);
//            viewManager.confirmOrder();

            // TODO: Coupon Service

            break;
        }
    }
}
