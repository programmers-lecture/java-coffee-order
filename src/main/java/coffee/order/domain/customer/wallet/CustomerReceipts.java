package coffee.order.domain.customer.wallet;

import coffee.order.domain.order.Orders;
import coffee.order.domain.receipt.Receipt;

import java.util.ArrayList;
import java.util.List;

public class CustomerReceipts {

    private final List<Receipt> receipts;

    public CustomerReceipts() {
        this.receipts = new ArrayList<>();
    }

    protected void addReceipt(Receipt kioskReceipt) {
        // TODO : 음식 수량 조정은 여기서의 역할이 아니다.
//        changeFoodQuantity(kioskReceipt);
        receipts.add(kioskReceipt);
    }

    private void changeFoodQuantity(Orders orders) {
        orders.changeFoodQuantityByThisOrders();
    }
}
