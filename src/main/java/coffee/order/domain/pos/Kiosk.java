package coffee.order.domain.pos;

import coffee.order.domain.customer.Customer;

public class Kiosk {

    private final KioskOrder kioskOrder = new KioskOrder();
    private final KioskCoupon kioskCoupon = new KioskCoupon();

    public void process(Customer customer) {
        kioskOrder.askOrder(customer);
        kioskCoupon.askCoupon(customer);
    }

}
