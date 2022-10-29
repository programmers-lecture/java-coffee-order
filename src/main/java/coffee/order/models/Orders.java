package coffee.order.models;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Orders {
    private final List<Order> orders;

    public Orders() {
        orders = new ArrayList<>();
    }

    public void createOrder(Customer customer, Menu menu, int count){
        orders.add(new Order(customer, menu, count));
    }

    public void checkOrderIsEmpty() {
        if(orders.isEmpty())
            throw new IllegalArgumentException("메뉴 주문을 하지 않았습니다.");
    }

    public List<Order> getCurrentOrdersByCustomer(Customer customer) {
        return orders.stream()
                .filter(order -> order.getCustomer().isSameObject(customer))
                .collect(Collectors.toList());
    }

    public int getCurrentOrdersCount(Customer customer) {
        return orders.stream()
                .filter(order -> order.getCustomer().isSameObject(customer))
                .map(Order::getOrderCount)
                .reduce(0, Integer::sum);
    }

    public int getCurrentOrdersPriceSum(Customer customer) {
        return orders.stream()
                .filter(order -> order.getCustomer().isSameObject(customer))
                .map(Order::getOrderPrice)
                .reduce(0, Integer::sum);
    }

    public Order getOrder(String number, Customer customer) {
        return orders.stream()
                .filter(o -> o.getOrderFoodNumber().equals(number) && o.getCustomer().isSameObject(customer))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("존재하지 않는 메뉴입니다."));
    }

    public List<Order> getCouponUseOrders(Customer customer) {
        return orders.stream()
                .filter(order -> order.getCustomer().isSameObject(customer) && order.getCouponUseCount() != 0)
                .collect(Collectors.toList());
    }
}
