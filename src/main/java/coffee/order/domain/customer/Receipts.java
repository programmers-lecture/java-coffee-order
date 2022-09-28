package coffee.order.domain.customer;

import coffee.order.domain.order.Orders;

import java.util.ArrayList;
import java.util.List;

public class Receipts {

    private List<Orders> receipts;

    public Receipts() {
        this.receipts = new ArrayList<>();
    }

    protected void addReceipt(Orders orders) {
        receipts.add(orders);
    }
}
