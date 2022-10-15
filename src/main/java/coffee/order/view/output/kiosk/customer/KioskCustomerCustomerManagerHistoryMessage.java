package coffee.order.view.output.kiosk.customer;

import static coffee.order.view.output.OutputView.print;
import static coffee.order.view.output.UnitMessage.ENTER;
import static coffee.order.view.output.kiosk.customer.KioskCustomerCustomerManagerMessage.KIOSK_ASK_PHONE_NUMBER;

public class KioskCustomerCustomerManagerHistoryMessage {

    public void printWhenAskPhoneNumber() {
        print(ENTER.unit + KIOSK_ASK_PHONE_NUMBER.message + ENTER.unit);
    }
}
