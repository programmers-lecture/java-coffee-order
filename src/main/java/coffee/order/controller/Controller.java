package coffee.order.controller;

import coffee.order.model.MenuType;
import coffee.order.model.Transaction;
import coffee.order.view.model.ConfirmMessage;
import coffee.order.view.model.CustomerOrder;
import coffee.order.view.model.NumberChoice;
import coffee.order.view.model.PhoneNumber;

import java.util.List;

public class Controller {
    private final ViewManager viewManager;
    private final ServiceManager serviceManager;

    public Controller() {
        viewManager = new ViewManager();
        serviceManager = new ServiceManager();
    }

    public void runCafeApplication() {
        serviceManager.initializeMenu();
        viewManager.greeting();

        while (true) {
            viewManager.showMenu(MenuType.getMenuTypes(), serviceManager.getMenu());

            Transaction newTransaction = runOrderSequence();

            // TODO: Coupon Service
            runCouponService(newTransaction);

            // TODO: 음료개수만큼 쿠폰 적립

            // TODO: 최종 주문 출력

//            break;
        }
    }

    private Transaction runOrderSequence() {
        List<CustomerOrder> customerOrder = viewManager.readMenuChoice();
        Transaction newTransaction = serviceManager.createNewTransaction(customerOrder);
        viewManager.confirmOrder(newTransaction);
        return newTransaction;
    }

    private void runCouponService(Transaction transaction) {
        ConfirmMessage couponAccumulationConfirm = viewManager.confirmCouponAccumulation();

        if (couponAccumulationConfirm.isCustomerSaidYes()) {
            PhoneNumber phoneNumber = viewManager.readPhoneNumber();
            Integer couponQuantity = serviceManager.getCouponQuantity(phoneNumber);
            viewManager.notifyCouponQuantity(couponQuantity);

            checkCouponApplicability(transaction, couponQuantity);
            serviceManager.addCoupon(transaction, phoneNumber);
        }
    }

    private void checkCouponApplicability(Transaction transaction, Integer couponQuantity) {
        if (serviceManager.checkCouponApplicability(couponQuantity)) {
            ConfirmMessage couponApplicationConfirm = viewManager.confirmCouponApplication();

            if (couponApplicationConfirm.isCustomerSaidYes()) {
                NumberChoice numberChoice = viewManager.confirmWhichMenuToApplyCoupon(transaction);
                serviceManager.applyCoupon(transaction, numberChoice);
                viewManager.confirmFinalOrder(transaction);
            }
        }
    }
}
