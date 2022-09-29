package coffee.order.domain.order;

import coffee.order.domain.customer.Customer;

import java.util.*;

import static coffee.order.exception.CustomerException.CUSTOMER_NOT_EXIST_ORDER_FOOD_NUMBER;
import static coffee.order.message.CouponMessage.KIOSK_ASK_TO_CHOOSE_ORDER;
import static coffee.order.message.KioskMessage.KIOSK_TOTAL_PRICE;
import static coffee.order.message.MessageUnit.WON;
import static coffee.order.view.OutputView.print;

public class Orders {

    private List<Order> orders;

    public Orders() {
        this.orders = new ArrayList<>();
    }

    public void addOrder(Order order) {
        orders.add(order);
    }

    public Order findOrderPurchasedByCoupon(Customer customer) {
        Map<String, Order> myOrders = new HashMap<>();
        print(KIOSK_ASK_TO_CHOOSE_ORDER.message);
        print(toStringOrdersToChoice(myOrders));
        return Optional.of(myOrders)
                .orElseThrow(CUSTOMER_NOT_EXIST_ORDER_FOOD_NUMBER::throwMyException)
                .get(customer.commands());
    }

    public int getTotalPrice() {
        return this.orders
                .stream()
                .mapToInt(Order::sumTotalPrice)
                .sum();
    }

    public void changeFoodQuantityByThisOrders() {
        this.orders.forEach(Order::changeFoodQuantityByThisOrder);
    }

    private String toStringOrdersToChoice(Map<String, Order> myOrders) {
        StringBuilder ordersToChoiceBuilder = new StringBuilder();
        orders.forEach(order -> {
                    String selectNumber = createMyOrdersSelectNumber(myOrders);
                    myOrders.put(
                            selectNumber,
                            order
                    );
                    ordersToChoiceBuilder
                            .append(selectNumber)
                            .append(". ")
                            .append(order.getFoodName())
                            .append("\n");
                }
        );
        return ordersToChoiceBuilder.toString();
    }

    private String createMyOrdersSelectNumber(Map<String, Order> myOrders) {
        return 1 + "-" + (myOrders.size() + 1);
    }

    private void createOrderListMessage(StringBuilder messageBuilder) {
        orders.forEach(order -> messageBuilder.append(order.createOrderHistory()));
    }

    private void createTotalPriceMessage(StringBuilder messageBuilder) {
        messageBuilder
                .append("\n")
                .append(KIOSK_TOTAL_PRICE.message)
                .append(orders.stream()
                        .mapToInt(Order::sumTotalPrice)
                        .sum())
                .append(WON.unit)
                .append("\n");
    }

    @Override
    public String toString() {
        StringBuilder messageBuilder = new StringBuilder();
        createOrderListMessage(messageBuilder);
        createTotalPriceMessage(messageBuilder);
        return messageBuilder.toString();
    }
}
