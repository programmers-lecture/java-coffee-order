package coffee.order.domain.kiosk.customer;

import coffee.order.domain.customer.Customer;
import coffee.order.domain.order.Order;
import coffee.order.domain.order.Orders;
import coffee.order.view.output.kiosk.customer.KioskCustomerHistoryMessage;

import java.util.Collection;
import java.util.Map;

public class KioskCustomer {

    private final KioskCustomerCustomerManager customerManager;
    private final KioskCustomerCouponManager couponManager;
    private final KioskCustomerOrderManager orderManager;

    public KioskCustomer() {
        this.customerManager = new KioskCustomerCustomerManager(this);
        this.couponManager = new KioskCustomerCouponManager(this);
        this.orderManager = new KioskCustomerOrderManager(this);
    }

    public KioskCustomerHistoryMessage kioskHistory() {
        return new KioskCustomerHistoryMessage();
    }

    public void processOrder() {
        orderManager.getOrders();
    }

    public void processCoupon() {
        couponManager.processSaveCoupon(customerManager);
        couponManager.processUseCoupon();
    }

    public void giveReceipt() {
        kioskHistory().printBeforeGiveReceipt();
        Customer customer = customerManager.loadCustomer();
        Orders orders = orderManager.loadOrders();
        customer.takeReceipt(orders);
        kioskHistory().printAfterGiveReceipt();
    }

    void createTempOrder(String orderCommand) {
        orderManager.createOrder(orderCommand);
    }

    Orders generateOrders() {
        return orderManager.loadOrders();
    }

    Customer loadCustomer() {
        return customerManager.loadCustomer();
    }

    void applyCoupon() {
        Collection<Order> orders = orderManager.loadOrders().getOrders();
        Map<String, Order> selectOrderMenu = orderManager.createSelectedMenu(orders);
        Order orderByCoupon = couponManager.findOrderedByCoupon(selectOrderMenu);
        orderByCoupon.changeCouponUsed();
    }

}
