package domain.barista;

import domain.order.Order;
import domain.coupon.Coupon;
import domain.cafe.Cafe;
import domain.order.OrderList;
import domain.menu.Menu;
import io.output.Output;

public class Barista {
    private final Cafe cafe;

    public Barista(Cafe cafe) {
        this.cafe = cafe;
    }
    public void takeOrder(OrderList orderList) {
        cafe.addOrderHistory(orderList);
        cafe.reduceMenuStock(orderList);
    }

    public void applyCoupon(Coupon coupon, Order order) {
        cafe.addCouponHistory(coupon);
        cafe.useCoupon(coupon);
        order.applyCoupon();
    }

    public void earnCoupon(Coupon coupon) {
        cafe.earnCoupon(coupon);
        Output.printSuccessfullyEarnedCoupon(cafe.getCouponCount(coupon));
    }

    public void showMenu() {
        cafe.showMenu();
    }

    public Menu getMenu() {
        return cafe.getMenu();
    }

    public boolean canUseCoupon(Coupon coupon) {
        return cafe.canUseCoupon(coupon);
    }
}
