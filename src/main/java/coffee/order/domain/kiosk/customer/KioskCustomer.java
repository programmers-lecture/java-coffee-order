package coffee.order.domain.kiosk.customer;

import coffee.order.domain.customer.Customer;
import coffee.order.domain.order.Order;
import coffee.order.domain.order.OrderGenerator;
import coffee.order.domain.order.Orders;
import coffee.order.view.output.kiosk.customer.KioskCustomerHistoryMessage;

import java.util.Collection;
import java.util.Map;

import static coffee.order.domain.customer.Customers.CUSTOMERS_DATA;

public class KioskCustomer {

    private Customer customer;

    private final OrderGenerator orderGenerator;
    private final KioskCustomerManager customerManager;
    private final KioskCouponManager couponManager;
    private final KioskOrderManager orderManager;

    public KioskCustomer() {
        customer = new Customer();
        this.orderGenerator = new OrderGenerator();
        this.customerManager = new KioskCustomerManager(this);
        this.couponManager = new KioskCouponManager(this);
        this.orderManager = new KioskOrderManager(this);
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
        customer.addMyOrders(orderGenerator.loadOrders());
        kioskHistory().printAfterGiveReceipt();
    }

    void createTempOrder(String orderCommand) {
        orderGenerator.createOrder(orderCommand);
    }

    Orders generateOrders() {
        return orderGenerator.loadOrders();
    }

    Customer loadCustomer() {
        return customer;
    }

    void applyCoupon() {
        Collection<Order> orders = orderGenerator.loadOrders().getOrders();
        Map<String, Order> selectOrderMenu = orderManager.createSelectedMenu(orders);
        Order orderByCoupon = couponManager.findOrderedByCoupon(selectOrderMenu);
        orderByCoupon.changeCouponUsed();
    }

    void loginCustomer(String phoneNumber) {
        customer = CUSTOMERS_DATA.findCustomerByPhoneNumber(phoneNumber);
    }

}
