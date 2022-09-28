package coffee.order.domain.pos;

import coffee.order.domain.customer.Customer;
import coffee.order.domain.order.Orders;

public class Kiosk {

    private final KioskOrder kioskOrder = new KioskOrder();
    private final KioskCoupon kioskCoupon = new KioskCoupon();

    public void process(Customer customer) {
        Orders customerOrders = kioskOrder.askOrder(customer);
        boolean checkCouponUsed = kioskCoupon.askCoupon(customer);

        if (checkCouponUsed) {
            customerOrders.getFirstOrder().changeCouponUsed();
        }

        customer.addMyOrder(customerOrders);
    }

}
