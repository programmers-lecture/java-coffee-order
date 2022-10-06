package coffee.order.domain.customer.wallet;

import coffee.order.domain.order.Orders;

import java.util.ArrayList;
import java.util.List;

public class Receipts {

    private final List<Orders> receipts;

    public Receipts() {
        this.receipts = new ArrayList<>();
    }

    protected void addReceipt(Orders orders) {
        changeFoodQuantity(orders);
        receipts.add(orders);
    }

    private void changeFoodQuantity(Orders orders) {
        orders.changeFoodQuantityByThisOrders();
    }
}
