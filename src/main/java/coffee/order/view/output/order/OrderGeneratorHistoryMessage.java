package coffee.order.view.output.order;

import coffee.order.dto.order.OrdersDto;

import static coffee.order.view.output.OutputView.print;
import static coffee.order.view.output.UnitMessage.WON;
import static coffee.order.view.output.order.OrdersMessage.ORDER_TOTAL_PRICE;

public class OrderGeneratorHistoryMessage {

    private final OrdersDto ordersDto;

    public OrderGeneratorHistoryMessage(OrdersDto ordersDto) {
        this.ordersDto = ordersDto;
    }

    public void printOrders() {
        StringBuilder sb = new StringBuilder();
        ordersDto.getOrders()
                .forEach(orderDto -> {
                            if (orderDto.checkCouponNotUsedOrNotZeroQuantity()) {
                                sb.append(orderDto.getOrderHistory());
                            }
                            if (orderDto.checkCouponUsed()) {
                                sb.append(orderDto.getOrderHistoryWhenUsedCoupon());
                            }
                        }
                );
        print(sb.toString());
        printTotalPrice();
    }

    private void printTotalPrice() {
        print("\n" + ORDER_TOTAL_PRICE.message + ordersDto.getTotalPrice() + WON.unit + "\n");
    }
}
