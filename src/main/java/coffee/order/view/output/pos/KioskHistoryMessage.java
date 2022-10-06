package coffee.order.view.output.pos;

import coffee.order.domain.order.Orders;

import static coffee.order.view.output.OutputView.print;
import static coffee.order.view.output.pos.KioskMessage.*;

public class KioskHistoryMessage {


    public void printLastReceipt(Orders orders) {
        orders.ordersHistory().printOrders();
    }

    public void printBeforeGiveReceipt() {
        print(KIOSK_AFTER_ORDER.message);
    }

    public void printAfterGiveReceipt() {
        print(KIOSK_FINISH_ORDER.message);
    }
}
