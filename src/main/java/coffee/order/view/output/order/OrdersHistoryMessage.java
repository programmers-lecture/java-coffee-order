package coffee.order.view.output.order;

import coffee.order.domain.order.Order;
import coffee.order.domain.order.Orders;

import java.util.Map;

import static coffee.order.view.output.OutputView.print;
import static coffee.order.view.output.UnitMessage.WON;
import static coffee.order.view.output.order.OrdersMessage.ORDER_ASK_TO_CHOOSE_ORDER;
import static coffee.order.view.output.order.OrdersMessage.ORDER_TOTAL_PRICE;

public class OrdersHistoryMessage {

    private final Orders orders;

    public OrdersHistoryMessage(Orders orders) {
        this.orders = orders;
    }

    public void printKioskToChoose() {
        print(ORDER_ASK_TO_CHOOSE_ORDER.message);
    }

    public void printToSelectMenuToUseCoupon(Map<String, Order> myOrders) {
        StringBuilder ordersToChoiceBuilder = new StringBuilder();
        for (Map.Entry<String, Order> entry : myOrders.entrySet()) {
            ordersToChoiceBuilder
                    .append(entry.getKey())
                    .append(". ")
                    .append(entry.getValue().getFoodName())
                    .append("\n");
        }
        print(ordersToChoiceBuilder.toString());
    }

    public void printOrders() {
        orders.getOrders()
                .forEach(order -> {
                    order.orderHistory().printOrderHistory();
                    order.orderHistory().printOrderCouponHistoryWhenCouponUsed();
                });
        printTotalPrice();
    }

    private void printTotalPrice() {
        print("\n" + ORDER_TOTAL_PRICE.message + orders.getTotalPrice() + WON.unit + "\n");
    }
}
