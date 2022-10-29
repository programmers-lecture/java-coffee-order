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

            Transaction transaction = runOrderSequence();
            viewManager.confirmOrder(transaction);

            runCouponService(transaction);
            viewManager.confirmOrder(transaction);
        }
    }

    private Transaction runOrderSequence() {
        List<CustomerOrder> customerOrder = viewManager.readMenuChoice();
        return serviceManager.createNewTransaction(customerOrder);
    }

    private void runCouponService(Transaction transaction) {
        ConfirmMessage couponAccumulationConfirm = viewManager.confirmCouponAccumulation();

        if (couponAccumulationConfirm.isCustomerSaidYes()) {
            PhoneNumber phoneNumber = viewManager.readPhoneNumber();
            Integer currentCouponQuantity = serviceManager.getCouponQuantity(phoneNumber);
            viewManager.notifyCouponQuantity(currentCouponQuantity);

            checkCouponApplicability(transaction, phoneNumber);
            serviceManager.addCoupon(transaction, phoneNumber);
        }
    }

    private void checkCouponApplicability(Transaction transaction, PhoneNumber phoneNumber) {
        if (serviceManager.checkCouponApplicability(phoneNumber)) {
            ConfirmMessage couponApplicationConfirm = viewManager.confirmCouponUsage();

            if (couponApplicationConfirm.isCustomerSaidYes()) {
                NumberChoice numberChoice = viewManager.confirmWhichMenuToUseCoupon(transaction);
                serviceManager.applyCoupon(transaction, numberChoice, phoneNumber);
            }
        }
    }
}
