package coffee.order.domain.customer;

import coffee.order.domain.customer.wallet.Wallet;
import coffee.order.domain.order.Orders;
import coffee.order.view.InputView;

public class Customer {

    private static final Long id = 1L;
    private Phone phone;
    private Wallet wallet;
    private Receipts receipts;

    public String order() {
        return InputView.read();
    }

    public void addMyOrder(Orders orders) {
        receipts.addReceipt(orders);
    }
}
