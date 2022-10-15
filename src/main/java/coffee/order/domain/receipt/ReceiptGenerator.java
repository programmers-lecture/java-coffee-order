package coffee.order.domain.receipt;

import coffee.order.domain.order.Orders;

public class ReceiptGenerator {

    private Receipt receipt;

    public Receipt generateReceipt(Orders orders) {
        receipt = new Receipt(orders);
        return receipt;
    }

    public Receipt loadReceipt() {
        return receipt;
    }

}
