package coffee.order.domain.customer.wallet;

import coffee.order.domain.order.Orders;

import java.util.ArrayList;
import java.util.List;

import static coffee.order.message.KioskMessage.KIOSK_AFTER_ORDER;
import static coffee.order.view.OutputView.print;

public class Receipts {

    private List<Orders> receipts;

    public Receipts() {
        this.receipts = new ArrayList<>();
    }

    public void addReceipt(Orders orders) {
        changeFoodQuantity(orders);
        receipts.add(orders);
        print(KIOSK_AFTER_ORDER.message);
        print(createRecentReceiptMessage());
    }

    public String createRecentReceiptMessage() {
        return receipts
                .get(receipts.size() - 1)
                .toString();
    }

    private void changeFoodQuantity(Orders orders) {
        orders.changeFoodQuantityByThisOrders();
    }
}
