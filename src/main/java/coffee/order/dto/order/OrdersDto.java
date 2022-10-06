package coffee.order.dto.order;

import java.util.Collection;
import java.util.Map;

public class OrdersDto {

    private final Map<String, OrderDto> ordersDto;

    public OrdersDto(Map<String, OrderDto> orders) {
        this.ordersDto = orders;
    }

    public Collection<OrderDto> getOrders() {
        return ordersDto.values();
    }

    public int getTotalPrice() {
        return this.ordersDto
                .values()
                .stream()
                .mapToInt(OrderDto::getTotalPrice)
                .sum();
    }
}
