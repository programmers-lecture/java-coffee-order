package coffee.order.controller;

import coffee.order.models.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Cafe {
    private Menus menus;
    private Orders orders;
    private Map<Customer, Coupon> couponMap;

    public Cafe() {
        this.menus = new Menus();
        this.orders = new Orders();
        this.couponMap = new HashMap<>();
    }

    public Menus getMenus() {
        return menus;
    }

    public Orders getOrders() {
        return orders;
    }

    public void createOrders(List<String[]> menuOrders, Customer customer) {
        for(String[] menuOrder: menuOrders) {
            String menuNumber = menuOrder[0];
            int menuOrderCount = Integer.parseInt(menuOrder[1]);
            orders.createOrder(customer, menus.getMenuByNumber(menuNumber), menuOrderCount);
        }
        orders.checkOrderIsEmpty();
    }

    public int earnCoupons(Customer customer) {
        Coupon coupon = couponMap.get(customer);
        if(coupon == null)
            coupon = new Coupon();
        int orderCnt = orders.getCurrentOrdersCount(customer);
        coupon.addCouponCnt(orderCnt);
        couponMap.put(customer, coupon);
        return coupon.getCount();
    }

    public void useCouponForOrder(Customer customer, String number) {
        Order order = orders.getOrder(number, customer);
        Coupon coupon = couponMap.get(customer);
        int couponUsableOrderCount = coupon.useCoupon(order.getOrderCount());
        order.useCouponForOrderedFood(couponUsableOrderCount);
    }
}
