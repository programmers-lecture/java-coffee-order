package coffee.order.domain.order;

import coffee.order.domain.customer.Customer;
import coffee.order.view.output.order.OrdersHistoryMessage;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

import static coffee.order.exception.CustomerException.CUSTOMER_NOT_CORRECT_ANSWER;
import static coffee.order.exception.CustomerException.CUSTOMER_NOT_EXIST_ORDER_FOOD_NUMBER;

public class Orders {

    private final Map<String, Order> orders;

    public Orders() {
        this.orders = new HashMap<>();
    }

    public OrdersHistoryMessage ordersHistory() {
        return new OrdersHistoryMessage(this);
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
        ordersHistory().printKioskToChoose();
        ordersHistory().printToSelectMenuToUseCoupon(myOrders);
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

    private String createMyOrdersSelectNumber(Map<String, Order> myOrders) {
        return 1 + "-" + (myOrders.size() + 1);
    }

    public Collection<Order> getOrders() {
        return orders.values();
    }

}
