package coffee.order.view.output.kiosk.customer;

import static coffee.order.view.output.OutputView.print;
import static coffee.order.view.output.UnitMessage.ENTER;
import static coffee.order.view.output.kiosk.customer.KioskCustomerMessage.KIOSK_AFTER_ORDER;
import static coffee.order.view.output.kiosk.customer.KioskCustomerMessage.KIOSK_FINISH_ORDER;

public class KioskCustomerHistoryMessage {

    public void printBeforeGiveReceipt() {
        print(ENTER.unit + KIOSK_AFTER_ORDER.message + ENTER.unit);
    }

    public void printAfterGiveReceipt() {
        print(ENTER.unit + KIOSK_FINISH_ORDER.message + ENTER.unit);
    }
}
