package coffee.order.domain.order;

import coffee.order.dto.order.OrderDto;
import coffee.order.dto.order.OrdersDto;
import coffee.order.view.output.order.OrderGeneratorHistoryMessage;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public class Orders {

    private final Map<String, Order> orders;

    public Orders() {
        this.orders = new HashMap<>();
    }

    public OrderGeneratorHistoryMessage ordersHistory() {
        return new OrderGeneratorHistoryMessage(this.toOrderDto());
    }

    public OrdersDto toOrderDto() {
        Map<String, OrderDto> ordersDto = new HashMap<>();
        orders.values()
                .forEach(order -> ordersDto.put(order.getFoodName(), order.toOrderDto()));
        return new OrdersDto(ordersDto);
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

    public Collection<Order> getOrders() {
        return orders.values();
    }

}
