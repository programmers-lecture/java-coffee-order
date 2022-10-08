package coffee.order.controller;

import coffee.order.model.MenuType;
import coffee.order.model.Transaction;
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

            // TODO: 거래내역 객체를 생성하고, DB에 저장, MessageHandler에 보내서 출력할 메시지 생성
            Order order = viewManager.readMenuChoice();
            Transaction newTransaction = serviceManager.createNewTransaction(order);
            viewManager.confirmOrder(newTransaction);

            // TODO: Coupon Service

            break;
        }
    }
}
