package coffee.order.view.output.order;

import coffee.order.domain.order.Order;

import static coffee.order.view.output.OutputView.print;
import static coffee.order.view.output.UnitMessage.COUNT;
import static coffee.order.view.output.order.OrderMessage.ORDER_COUPON_USE;

public class OrderHistoryMessage {

    private final Order order;

    public OrderHistoryMessage(Order order) {
        this.order = order;
    }

    public void printOrderHistory() {
        if (order.checkCouponNotUsedOrNotZeroQuantity()) {
            print(order.toString());
        }
    }

    public void printOrderCouponHistoryWhenCouponUsed() {
        if (order.checkCouponUsed()) {
            print(order.getFoodName() + " " + 1 + COUNT.unit + " " + ORDER_COUPON_USE.message + "\n");
        }
    }
}
