package coffee.order.controller;

import coffee.order.enums.FoodCategory;
import coffee.order.models.*;
import coffee.order.views.InputView;
import coffee.order.views.OutputView;

import java.util.List;

public class Kiosk {
    public void run() {
        Cafe cafe = new Cafe();
        boolean isOrderEnd = false;
        while(!isOrderEnd) {
            Customer customer = new Customer();
            selectMenu(cafe, customer);
            int couponsCnt = earnCoupons(cafe, customer);
            useCoupons(cafe, customer, couponsCnt);
            OutputView.printOrderEnd();
            isOrderEnd = InputView.inputOrderEnd();
        }
    }

    public void selectMenu(Cafe cafe, Customer customer) {
        OutputView.printMenuSelect();
        for(FoodCategory foodCategory: FoodCategory.values()) {
            OutputView.printMenuCategory(foodCategory.getNumber(), foodCategory.getCategory());
            List<String> menuFoods = cafe.getMenuInfo(foodCategory);
            OutputView.printMenuFoods(menuFoods);
        }
        List<String> orders = InputView.inputOrder();
        cafe.createOrders(orders, customer);
        OutputView.printOrdersStart();
        OutputView.printOrdersInfo(cafe.getOrdersInfo(customer));
        OutputView.printTotalPriceSum(cafe.getOrdersPriceSum(customer));
    }

    public int earnCoupons(Cafe cafe, Customer customer) {
        String phoneNumber = InputView.inputPhoneNumberForEarnCoupon();
        int ordersCnt = cafe.getOrderFoodsCnt(customer);
        customer.addPhoneNumberInfo(phoneNumber);
        int couponsCnt = cafe.earnCoupons(customer, ordersCnt);
        OutputView.printCouponCnt(couponsCnt);
        return couponsCnt;
    }

    public void useCoupons(Cafe cafe, Customer customer, int couponsCnt) {
        if (Coupon.isCouponUsePossible(couponsCnt) && InputView.inputCouponUseOrNot()) {
            String couponUseFoodNumber = InputView.inputOrderFoodForUseCoupon(cafe.getOrdersInfoForCouponUse(customer));
            cafe.useCouponForOrderedFood(couponUseFoodNumber, customer);
            OutputView.printCouponUse();
            OutputView.printOrdersStart();
            OutputView.printOrdersInfo(cafe.getCouponUseOrdersInfo(customer));
            OutputView.printOrdersInfo(cafe.getOrdersInfo(customer));
            OutputView.printTotalPriceSum(cafe.getOrdersPriceSum(customer));
        }
    }
}
