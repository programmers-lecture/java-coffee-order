package coffee.order.domain.customer.wallet;

import coffee.order.domain.receipt.Receipt;

import java.util.ArrayList;
import java.util.List;

public class CustomerReceipts {

    private final List<Receipt> receipts;

    public CustomerReceipts() {
        this.receipts = new ArrayList<>();
    }

    protected void addReceipt(Receipt kioskReceipt) {
        receipts.add(kioskReceipt);
    }

}
