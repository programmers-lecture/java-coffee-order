package coffee.order.controller;

import coffee.order.model.MenuType;
import coffee.order.model.Transaction;
import coffee.order.view.ConfirmMessage;
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
            Transaction newTransaction = serviceManager.createNewTransaction(order);
            viewManager.confirmOrder(newTransaction);

            // TODO: Coupon Service
            ConfirmMessage confirmMessage = viewManager.confirmCouponUse();
//            if (confirmMessage.isCustomerSaidYes()) {
//                serviceManager.
//            }

            // TODO: 최종 주문

            break;
        }
    }
}
