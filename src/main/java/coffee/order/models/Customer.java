package coffee.order.models;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Customer {
    private String phoneNumber;
    private Coupon coupon;
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

    public void createCoupons(String phoneNumber) {
        this.phoneNumber = phoneNumber;
        coupon = new Coupon(orders.size());
    }

    public Coupon getCoupon() {
        return coupon;
    }
}
