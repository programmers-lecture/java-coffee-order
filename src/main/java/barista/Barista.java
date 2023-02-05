package barista;

import coupon.Coupon;
import cafe.Cafe;
import cafe.Order;

public class Barista {
    public void takeOrder(Cafe cafe, Order order) {
        cafe.addOrderHistory(order);
    }

    public void applyCoupon(Cafe cafe, Coupon coupon) {
        cafe.addCouponHistory(coupon);
    }
}
