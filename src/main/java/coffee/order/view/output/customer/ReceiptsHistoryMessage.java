package coffee.order.view.output.customer;

import coffee.order.domain.customer.wallet.Receipts;

import static coffee.order.view.output.OutputView.print;
import static coffee.order.view.output.customer.ReceiptsMessage.RECEIPT_AFTER_ORDER;
import static coffee.order.view.output.customer.ReceiptsMessage.RECEIPT_FINISH_ORDER;

public class ReceiptsHistoryMessage {

    private final Receipts receipts;

    public ReceiptsHistoryMessage(Receipts receipts) {
        this.receipts = receipts;
    }

    public void printLastReceipt() {
        receipts.getLastReceipt().ordersHistory().printOrders();
    }

    public void printBeforeGetReceipt() {
        print(RECEIPT_AFTER_ORDER.message);
    }

    public void printAfterGetReceipt() {
        print(RECEIPT_FINISH_ORDER.message);
    }
}
