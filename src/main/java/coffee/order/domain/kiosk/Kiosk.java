package coffee.order.domain.kiosk;

import coffee.order.domain.customer.Customer;
import coffee.order.domain.order.Order;
import coffee.order.domain.order.Orders;
import coffee.order.view.output.pos.KioskHistoryMessage;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public class Kiosk {

    public void processKiosk(Customer customer) {
        KioskOrderManager kioskOrder = new KioskOrderManager();
        KioskCouponManager kioskCoupon = new KioskCouponManager(customer);

        Orders customerOrders = kioskOrder.processOrder();
        boolean checkCouponUsed = kioskCoupon.processCoupon();

        if (checkCouponUsed) {
            Map<String, Order> selectedOrders = createSelectedMenu(customerOrders.getOrders());
            Order orderPurchasedByCoupon = kioskCoupon.findOrderPurchasedByCoupon(selectedOrders);
            orderPurchasedByCoupon.changeCouponUsed();
        }

        customer.addMyOrders(customerOrders);
        kioskHistory().printBeforeGiveReceipt();
        kioskHistory().printLastReceipt(customerOrders);
        kioskHistory().printAfterGiveReceipt();
    }

    public KioskHistoryMessage kioskHistory() {
        return new KioskHistoryMessage();
    }

    private Map<String, Order> createSelectedMenu(Collection<Order> orders) {
        Map<String, Order> customerOrders = new HashMap<>();
        orders.forEach(order -> {
                            String selectNumber = createSelectNumberBySelectedMenu(customerOrders);
                            customerOrders.put(selectNumber, order);
                        }
                );
        return customerOrders;
    }

    private String createSelectNumberBySelectedMenu(Map<String, Order> myOrders) {
        return 1 + "-" + (myOrders.size() + 1);
    }


}
