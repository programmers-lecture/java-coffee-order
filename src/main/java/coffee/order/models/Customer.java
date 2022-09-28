package coffee.order.models;

import java.util.*;

public class Customer {
    private static Set<Coupon> coupons = new HashSet<>();

    private List<Order> orders;

    public Customer() {
        this.orders = new ArrayList<>();
    }

    public void createOrders(List<String> orders) {
        for(String order: orders) {
            String[] orderInfo = order.split(", ");
            this.orders.add(new Order(orderInfo[0], Integer.parseInt(orderInfo[1])));
        }
        checkOrderIsEmpty();
    }

    private void checkOrderIsEmpty() {
        if(orders.isEmpty())
            throw new IllegalArgumentException("메뉴 주문을 하지 않았습니다.");
    }

    public List<Order> getOrders() {
        return Collections.unmodifiableList(orders);
    }

    public void useCouponForOrderedMenu(String number) {
        Order order = orders.stream()
                .filter(o -> o.getMenuNumber().equals(number))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("존재하지 않는 메뉴입니다."));
        order.useCouponForOrder();
    }

    public Coupon createCoupons(String phoneNumber) {
        Coupon coupon = coupons.stream()
                .filter(c -> c.getPhoneNumber().equals(phoneNumber))
                .findFirst()
                .orElse(null);
        if(coupon == null) {
            coupon = new Coupon(phoneNumber);
            coupons.add(coupon);
            return coupon;
        }
        coupon.earnCoupon();
        return coupon;
    }

}
