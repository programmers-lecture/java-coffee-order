package coffee.order.domain.kiosk.customer;

import coffee.order.domain.customer.Customer;
import coffee.order.domain.customer.Phone;
import coffee.order.domain.kiosk.KioskManager;
import coffee.order.domain.kiosk.setting.KioskSetting;
import coffee.order.domain.order.Order;
import coffee.order.domain.order.Orders;
import coffee.order.domain.receipt.Receipt;
import coffee.order.view.output.kiosk.customer.KioskCustomerHistoryMessage;

import java.util.Collection;
import java.util.Map;

public class KioskCustomer {

    private final KioskManager kioskManager;
    private final KioskCustomerCustomerManager customerManager;
    private final KioskCustomerCouponManager couponManager;
    private final KioskCustomerOrderManager orderManager;
    private final KioskCustomerReceiptManager receiptManager;

    public KioskCustomer(KioskManager kioskManager) {
        this.kioskManager = kioskManager;
        this.customerManager = new KioskCustomerCustomerManager(this);
        this.couponManager = new KioskCustomerCouponManager(this);
        this.orderManager = new KioskCustomerOrderManager();
        this.receiptManager = new KioskCustomerReceiptManager();
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
        Orders orders = orderManager.loadOrders();
        Receipt receipt = receiptManager.createReceipt(orders);
        customerManager.giveReceipt(receipt);
        kioskHistory().printAfterGiveReceipt();
    }

    public void reflectOrders() {
        Orders orders = orderManager.loadOrders();
        kioskManager.loadKioskSetting().reflectOrders(orders);
    }

    public void reflectReceipt() {
        Phone phone = customerManager.loadCustomer().answerPhoneNumber();
        Receipt receipt = receiptManager.loadReceipt();
        kioskManager.loadKioskSetting().reflectReceipt(phone, receipt);
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
