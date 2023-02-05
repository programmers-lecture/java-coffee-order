package cafe;

import coupon.Coupon;
import io.output.Output;
import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

public class Cafe {
    private static final int FIRST_ORDER = 1;
    private static final int ONE = 1;
    private BigDecimal sales;
    private Map<Integer, Order> orderHistory;
    private Map<Coupon, Integer> couponHistory;

    public Cafe() {
        this.sales = BigDecimal.ZERO;
        this.orderHistory = new HashMap<>();
        this.couponHistory = new HashMap<>();
    }

    public void checkOrderHistory() {
        Output.printOrderHistory(orderHistory, sales);
    }

    public void checkCouponHistory() {
        Output.printCouponHistory(couponHistory);
    }

    public void addOrderHistory(Order order) {
        if(orderHistory.isEmpty()) {
            orderHistory.put(FIRST_ORDER, order);
            addSales(order);
            return;
        }
        int orderNumber = orderHistory.size() + ONE;
        orderHistory.put(orderNumber, order);
        addSales(order);
    }

    public void addCouponHistory(Coupon coupon) {
        couponHistory.put(coupon, couponHistory.getOrDefault(coupon, 0) + 1);
    }

    private void addSales(Order order) {
        sales = sales.add(order.getPrice());
    }
}
