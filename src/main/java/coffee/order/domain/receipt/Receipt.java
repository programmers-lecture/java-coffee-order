package coffee.order.domain.receipt;

import coffee.order.domain.order.Orders;
import coffee.order.dto.receipt.ReceiptDto;

import java.time.LocalDateTime;

import static java.time.LocalDateTime.now;

public class Receipt {

    private final Orders orders;
    private final LocalDateTime localDateTime;

    public Receipt(Orders orders) {
        this.orders = orders;
        this.localDateTime = now();
    }

    public ReceiptDto toReceiptDto() {
        return new ReceiptDto(orders.toOrderDto(), localDateTime);
    }
}
