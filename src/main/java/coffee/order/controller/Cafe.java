package coffee.order.controller;

import coffee.order.models.Coupon;
import coffee.order.models.Customer;
import coffee.order.models.Order;
import coffee.order.views.InputView;
import coffee.order.views.OutputView;

import java.util.List;

public class Cafe {
    private Cafe() {}

    public static void runCafe() {
        boolean isOrderEnd = false;
        while(!isOrderEnd) {
            OutputView.printMenu();
            List<String> orders = InputView.inputOrder();
            Customer customer = new Customer();
            customer.createOrders(orders);
            OutputView.printOrders(customer.getOrders());
            String phoneNumber = InputView.inputPhoneNumberForEarnCoupon();
            Coupon coupon = customer.createCoupons(phoneNumber);
            OutputView.printCouponCnt(coupon.getCount());
            if (coupon.isCouponUsePossible()) {
                String couponUseMenu = InputView.inputCouponUseForMenu(customer.getOrders());
                coupon.useCoupon();
                customer.useCouponForOrderedMenu(couponUseMenu);
                OutputView.printCouponUse();
                OutputView.printOrders(customer.getOrders());
            }
            OutputView.printOrderEnd();
            isOrderEnd = InputView.inputOrderEnd();
        }
    }
}
