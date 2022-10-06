package coffee.order.view.output.order;

import coffee.order.dto.order.OrderDto;

public class OrderHistoryMessage {

    private final OrderDto orderDto;

    public OrderHistoryMessage(OrderDto orderDto) {
        this.orderDto = orderDto;
    }

}
