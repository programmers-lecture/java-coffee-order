package coffee.order.controller;

import coffee.order.enums.MenuCategory;
import coffee.order.models.*;
import coffee.order.views.InputView;
import coffee.order.views.OutputView;

import java.util.List;
import java.util.stream.Collectors;

public class Kiosk {
    public Kiosk() {}

    public boolean isKioskEnd() {
        return InputView.inputOrderEnd();
    }

    public void showMenus(Menus menus) {
        OutputView.printMenuSelect();
        for(MenuCategory category: MenuCategory.values()) {
            OutputView.printMenuCategory(category.getNumber(), category.getCategory());
            List<String> menuFoods = getMenuInfo(menus, category);
            OutputView.printMenuFoods(menuFoods);
        }
    }

    public List<String[]> selectMenus() {
        return InputView.inputOrder().stream()
                .map(order -> order.split(", "))
                .collect(Collectors.toList());
    }

    private List<String> getMenuInfo(Menus menus, MenuCategory category){
        return menus.getMenusByCategory(category)
                .stream()
                .map(food -> food.getNumber() + " " + food.getName())
                .collect(Collectors.toList());
    }

    public void showOrders(Orders orders, Customer customer) {
        OutputView.printOrdersStart();
        OutputView.printOrdersInfo(getOrdersInfo(orders.getCurrentOrdersByCustomer(customer)));
        OutputView.printTotalPriceSum(orders.getCurrentOrdersPriceSum(customer));
    }

    private List<String> getOrdersInfo(List<Order> orders) {
        return orders.stream()
                .map(order -> order.getOrderMenuName() + " " + order.getOrderCount() + "개 " + order.getOrderPrice() + "원")
                .collect(Collectors.toList());
    }

    public void earnCoupons(Customer customer) {
        String phoneNumber = InputView.inputPhoneNumberForEarnCoupon();
        customer.addPhoneNumberInfo(phoneNumber);
    }

    public void showCoupons(int couponsCnt) {
        OutputView.printCouponCnt(couponsCnt);
    }

    public boolean isCustomerUseCoupons(int couponsCnt) {
        return Coupon.isCouponUsePossible(couponsCnt) && InputView.inputCouponUseOrNot();
    }

    public String selectCouponsUseMenu(Orders orders, Customer customer) {
            List<String> currentOrders = getOrdersForCouponUse(orders.getCurrentOrdersByCustomer(customer));
            return InputView.inputOrderFoodForUseCoupon(currentOrders);
    }

    public void showCouponsUseMenu(Orders orders, Customer customer) {
        OutputView.printCouponUse();
        OutputView.printOrdersStart();
        OutputView.printOrdersInfo(getCouponUseOrders(orders.getCouponUseOrders(customer)));
        OutputView.printOrdersInfo(getOrdersInfo(orders.getCurrentOrdersByCustomer(customer)));
        OutputView.printTotalPriceSum(orders.getCurrentOrdersPriceSum(customer));
    }

    private List<String> getCouponUseOrders(List<Order> orders) {
        return orders.stream()
                .map(order -> order.getOrderMenuName() + " " + order.getCouponUseCount() + "개 쿠폰사용")
                .collect(Collectors.toList());
    }

    private List<String> getOrdersForCouponUse(List<Order> orders) {
        return orders.stream()
                .map(order -> order.getOrderFoodNumber() + ". " + order.getOrderMenuName())
                .collect(Collectors.toList());
    }

}
