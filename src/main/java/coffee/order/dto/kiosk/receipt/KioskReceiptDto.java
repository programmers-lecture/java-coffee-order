package coffee.order.dto.kiosk.receipt;

import coffee.order.dto.customer.PhoneDto;
import coffee.order.dto.order.OrdersDto;

import static coffee.order.view.output.UnitMessage.*;

public class KioskReceiptDto {

    private final PhoneDto phoneDto;
    private final OrdersDto ordersDto;

    public KioskReceiptDto(PhoneDto phoneDto, OrdersDto ordersDto) {
        this.phoneDto = phoneDto;
        this.ordersDto = ordersDto;
    }

    public String receiptText() {
        StringBuilder receiptTextBuilder = new StringBuilder();
        ordersDto.getOrders()
                .forEach(orderDto -> receiptTextBuilder
                        .append(orderDto.getMenuNumber())
                        .append(SPACE.unit)
                        .append(orderDto.getFoodName())
                        .append(SPACE.unit)
                        .append(orderDto.getQuantity())
                        .append(COUNT.unit)
                        .append(SPACE.unit)
                        .append(SLASH.unit)
                        .append(SPACE.unit));
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
