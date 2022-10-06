package coffee.order.domain.pos;

import coffee.order.domain.customer.Customer;
import coffee.order.domain.order.Order;
import coffee.order.domain.order.Orders;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public class Kiosk {

    public void orderProcess(Customer customer) {
        KioskOrder kioskOrder = new KioskOrder(customer);
        KioskCoupon kioskCoupon = new KioskCoupon(customer);

        Orders customerOrders = kioskOrder.askOrder();
        boolean checkCouponUsed = kioskCoupon.askCoupon();

        if (checkCouponUsed) {
            Map<String, Order> selectedOrders = createSelectedMenu(customerOrders.getOrders());
            Order orderPurchasedByCoupon = kioskCoupon.findOrderPurchasedByCoupon(selectedOrders);
            orderPurchasedByCoupon.changeCouponUsed();
        }

        customer.addMyOrders(customerOrders);
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
