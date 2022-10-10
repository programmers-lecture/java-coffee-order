package coffee.order.dto.receipt;

import coffee.order.dto.order.OrdersDto;

import java.time.LocalDateTime;

import static coffee.order.view.output.UnitMessage.*;

public class ReceiptDto {

    private final OrdersDto ordersDto;

    private final LocalDateTime localDateTime;

    public ReceiptDto(OrdersDto ordersDto, LocalDateTime localDateTime) {
        this.ordersDto = ordersDto;
        this.localDateTime = localDateTime;
    }

    public String receiptText() {
        StringBuilder receiptTextBuilder = new StringBuilder();
        ordersDto.getOrders()
                .forEach(orderDto -> {
                    receiptTextBuilder
                            .append(orderDto.getMenuNumber())
                            .append(SPACE.unit)
                            .append(orderDto.getFoodName())
                            .append(SPACE.unit)
                            .append(orderDto.getQuantity())
                            .append(COUNT.unit);

                    if (orderDto.checkCouponUsed()) {
                        receiptTextBuilder
                                .append(LEFT_BRACKET.unit)
                                .append(COUPON_USED.unit)
                                .append(RIGHT_BRACKET.unit)
                                .append(SPACE.unit);
                    }

                    receiptTextBuilder
                            .append(SPACE.unit)
                            .append(SLASH.unit)
                            .append(SPACE.unit);
                });

        receiptTextBuilder
                .append(SPACE.unit)
                .append(RIGHT_ARROW.unit)
                .append(SPACE.unit)
                .append(TOTAL.unit)
                .append(SPACE.unit)
                .append(ordersDto.getTotalPrice())
                .append(WON.unit)
                .append(ENTER.unit);

        return receiptTextBuilder.toString();
    }
}
