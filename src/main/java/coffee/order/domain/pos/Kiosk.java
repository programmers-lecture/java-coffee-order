package coffee.order.domain.pos;

import coffee.order.domain.customer.Customer;
import coffee.order.domain.order.Orders;

public class Kiosk {

    public void orderProcess(Customer customer) {
        Orders customerOrders = new KioskOrder(customer).askOrder();
        boolean checkCouponUsed = new KioskCoupon(customer).askCoupon();

        if (checkCouponUsed) {
            customerOrders
                    .getFirstOrder()
                    .changeCouponUsed();
        }

        customer.addMyOrder(customerOrders);
    }

}
