package coffee.order.domain.order;

import coffee.order.domain.customer.Customer;

import java.util.*;
import java.util.stream.IntStream;

import static coffee.order.exception.CustomerException.CUSTOMER_NOT_EXIST_ORDER_FOOD_NUMBER;
import static coffee.order.exception.CustomerException.CUSTOMER_NOT_CORRECT_ANSWER;
import static coffee.order.message.CouponMessage.KIOSK_ASK_TO_CHOOSE_ORDER;
import static coffee.order.message.KioskMessage.KIOSK_TOTAL_PRICE;
import static coffee.order.message.MessageUnit.WON;
import static coffee.order.view.OutputView.print;

public class Orders {

    private final Map<String, Order> orders;

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
        Map<String, Order> myOrders = createSelectMenuToUseCoupon();
        print(KIOSK_ASK_TO_CHOOSE_ORDER.message);
        print(messageSelectMenusToUseCoupon(myOrders));
        String customerAnswer = askCustomerToUserCoupon(customer);
        return Optional.of(myOrders)
                .orElseThrow(() -> new NullPointerException(CUSTOMER_NOT_EXIST_ORDER_FOOD_NUMBER.getMessage()))
                .get(customerAnswer);
    }

    private Map<String, Order> createSelectMenuToUseCoupon() {
        Map<String, Order> myOrders = new HashMap<>();
        orders.values()
                .forEach(order -> {
                            String selectNumber = createMyOrdersSelectNumber(myOrders);
                            myOrders.put(selectNumber, order);
                        }
                );
        return myOrders;
    }

    private String askCustomerToUserCoupon(Customer customer) {
        return Optional.of(customer.commands())
                .orElseThrow(() -> new IllegalArgumentException(CUSTOMER_NOT_CORRECT_ANSWER.getMessage()));
    }

    public int getTotalPrice() {
        return this.orders
                .values()
                .stream()
                .mapToInt(Order::getTotalPrice)
                .sum();
    }

    public void changeFoodQuantityByThisOrders() {
        this.orders.values()
                .forEach(Order::changeFoodQuantityByThisOrder);
    }

    private String messageSelectMenusToUseCoupon(Map<String, Order> myOrders) {
        StringBuilder ordersToChoiceBuilder = new StringBuilder();

        int number = 0;
        for (String foodName : myOrders.keySet()) {
            ordersToChoiceBuilder
                    .append(number)
                    .append(". ")
                    .append(orders.get(foodName))
                    .append("\n");
        }
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
                        .mapToInt(Order::getTotalPrice)
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
