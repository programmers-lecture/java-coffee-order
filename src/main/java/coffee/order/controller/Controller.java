package coffee.order.controller;

import coffee.order.model.MenuType;
import coffee.order.model.Transaction;
import coffee.order.view.model.ConfirmMessage;
import coffee.order.view.model.Order;
import coffee.order.view.model.PhoneNumber;

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
            ConfirmMessage confirmMessage = viewManager.confirmCouponAccumulation();
            if (confirmMessage.isCustomerSaidYes()) {
                PhoneNumber phoneNumber = viewManager.readPhoneNumber();
                Integer couponQuantity = serviceManager.getCouponQuantity(phoneNumber);
                viewManager.notifyCouponQuantity(couponQuantity);

                if (serviceManager.checkCouponApplicability(couponQuantity)) {
//                    ConfirmMessage couponApplicationConfirm = viewManager.confirmCouponApplication();
                }

            }

            // TODO: 음료개수만큼 쿠폰 적립

            // TODO: 최종 주문 출력

            break;
        }
    }
}
