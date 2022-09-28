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

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        createOrderListMessage(sb);
        createTotalPriceMessage(sb);
        return sb.toString();
    }

    private void createOrderListMessage(StringBuilder sb) {
        orders.forEach(order -> sb.append(order.createOrderHistory()));
    }

    private StringBuilder createTotalPriceMessage(StringBuilder sb) {
        return sb.append(TOTAL_PRICE.message)
                .append(orders.stream()
                        .mapToInt(Order::sumTotalPrice)
                        .sum())
                .append(WON.unit)
                .append("\n");
    }
}
