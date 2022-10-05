package coffee.order.domain.customer.wallet;

import coffee.order.domain.order.Orders;
import coffee.order.view.output.customer.ReceiptsHistoryMessage;

import java.util.ArrayList;
import java.util.List;

public class Receipts {

    private final List<Orders> receipts;

    public Receipts() {
        this.receipts = new ArrayList<>();
    }

    public ReceiptsHistoryMessage receiptsHistory() {
        return new ReceiptsHistoryMessage(this);
    }

    protected void addReceipt(Orders orders) {
        changeFoodQuantity(orders);
        receipts.add(orders);
        receiptsHistory().printBeforeGetReceipt();
        receiptsHistory().printLastReceipt();
        receiptsHistory().printAfterGetReceipt();
    }

    public Orders getLastReceipt() {
        return receipts.get(receipts.size() - 1);
    }

    private void changeFoodQuantity(Orders orders) {
        orders.changeFoodQuantityByThisOrders();
    }
}
