package coffee.order.view.output.kiosk;

import static coffee.order.view.output.OutputView.print;
import static coffee.order.view.output.kiosk.KioskCustomerManagerMessage.KIOSK_ASK_PHONE_NUMBER;

public class KioskCustomerManagerHistoryMessage {

    public void printWhenAskPhoneNumber() {
        print(KIOSK_ASK_PHONE_NUMBER.message);
    }
}
