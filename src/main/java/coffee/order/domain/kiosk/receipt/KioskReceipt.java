package coffee.order.domain.kiosk.receipt;

import coffee.order.domain.customer.Phone;
import coffee.order.domain.order.Orders;
import coffee.order.dto.kiosk.receipt.KioskReceiptDto;

public class KioskReceipt {

    private final Phone phone;
    private final Orders orders;

    public KioskReceipt(Phone phone, Orders orders) {
        this.phone = phone;
        this.orders = orders;
    }

    public KioskReceiptDto toKioskReceiptDto() {
        return new KioskReceiptDto(phone.toPhoneDto(), orders.toOrderDto());
    }
}
