package coffee.order.domain.kiosk.customer;

import coffee.order.domain.order.Orders;
import coffee.order.domain.receipt.Receipt;
import coffee.order.domain.receipt.ReceiptGenerator;

public class KioskCustomerReceiptManager {

    private final ReceiptGenerator kioskReceiptGenerator;

    public KioskCustomerReceiptManager() {
        this.kioskReceiptGenerator = new ReceiptGenerator();
    }

    public Receipt createReceipt(Orders orders) {
        return kioskReceiptGenerator.generateReceipt(orders);
    }

    public Receipt loadReceipt() {
        return kioskReceiptGenerator.loadReceipt();
    }

}
