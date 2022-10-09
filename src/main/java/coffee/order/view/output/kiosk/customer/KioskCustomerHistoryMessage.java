package coffee.order.view.output.kiosk.customer;

import static coffee.order.view.output.OutputView.print;
import static coffee.order.view.output.kiosk.customer.KioskCustomerMessage.KIOSK_AFTER_ORDER;
import static coffee.order.view.output.kiosk.customer.KioskCustomerMessage.KIOSK_FINISH_ORDER;

public class KioskCustomerHistoryMessage {

    public void printBeforeGiveReceipt() {
        print(KIOSK_AFTER_ORDER.message);
    }

    public void printAfterGiveReceipt() {
        print(KIOSK_FINISH_ORDER.message);
    }
}
