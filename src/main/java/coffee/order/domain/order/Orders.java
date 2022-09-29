package coffee.order.domain.order;

import coffee.order.domain.customer.Customer;

import java.util.*;

import static coffee.order.exception.CustomerException.CUSTOMER_NOT_EXIST_ORDER_FOOD_NUMBER;
import static coffee.order.message.CouponMessage.KIOSK_ASK_TO_CHOOSE_ORDER;
import static coffee.order.message.KioskMessage.KIOSK_TOTAL_PRICE;
import static coffee.order.message.MessageUnit.WON;
import static coffee.order.view.OutputView.print;

public class Orders {

    private Map<String, Order> orders;

    public Orders() {
        this.orders = new HashMap<>();
    }

    public void addOrder(Order order) {
        addOrderWhenThisFoodHasBeenChosen(order);
        addOrderWhenThisFoodHasNotBeenChosen(order);
    }

    private void addOrderWhenThisFoodHasBeenChosen(Order order) {
        if (orders.containsKey(order.getFoodName())) {
            orders.get(order.getFoodName())
                    .changeFoodQuantityWhenDuplicated(order);
        }
    }

    private void addOrderWhenThisFoodHasNotBeenChosen(Order order) {
        if (!orders.containsKey(order.getFoodName())) {
            orders.put(order.getFoodName(), order);
        }
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
                .values()
                .stream()
                .mapToInt(Order::sumTotalPrice)
                .sum();
    }

    public void changeFoodQuantityByThisOrders() {
        this.orders.values()
                .forEach(Order::changeFoodQuantityByThisOrder);
    }

    private String toStringOrdersToChoice(Map<String, Order> myOrders) {
        StringBuilder ordersToChoiceBuilder = new StringBuilder();
        orders.values()
                .forEach(order -> {
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
        orders.values()
                .forEach(order -> messageBuilder.append(order.createOrderHistory()));
    }

    private void createTotalPriceMessage(StringBuilder messageBuilder) {
        messageBuilder
                .append("\n")
                .append(KIOSK_TOTAL_PRICE.message)
                .append(orders.values()
                        .stream()
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
