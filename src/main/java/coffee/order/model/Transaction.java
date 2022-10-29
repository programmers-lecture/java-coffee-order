package coffee.order.model;

import java.util.List;

public class Transaction {
    private final List<Order> orders;

    public Transaction(List<Order> orders) {
        this.orders = orders;
    }

    public List<Order> getOrders() {
        return orders;
    }

    public boolean isCouponApplied() {
        return orders.stream()
                .anyMatch(Order::isCouponApplied);
    }
}
