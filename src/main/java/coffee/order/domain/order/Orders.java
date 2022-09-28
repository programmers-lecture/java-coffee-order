package coffee.order.domain.order;

import java.util.ArrayList;
import java.util.List;

import static coffee.order.message.MessageUnit.WON;
import static coffee.order.message.OrderMessage.TOTAL_PRICE;

public class Orders {

    private List<Order> orders;

    public Orders() {
        this.orders = new ArrayList<>();
    }

    public void addOrder(Order order) {
        orders.add(order);
    }

    public int getTotalPrice() {
        return this.orders
                .stream()
                .mapToInt(Order::sumTotalPrice)
                .sum();
    }

    @Override
    public String toString() {
        StringBuilder messageBuilder = new StringBuilder();
        createOrderListMessage(messageBuilder);
        createTotalPriceMessage(messageBuilder);
        return messageBuilder.toString();
    }

    private void createOrderListMessage(StringBuilder messageBuilder) {
        orders.forEach(order -> messageBuilder.append(order.createOrderHistory()));
    }

    private void createTotalPriceMessage(StringBuilder messageBuilder) {
        messageBuilder
                .append(TOTAL_PRICE.message)
                .append(orders.stream()
                        .mapToInt(Order::sumTotalPrice)
                        .sum())
                .append(WON.unit)
                .append("\n");
    }
}
