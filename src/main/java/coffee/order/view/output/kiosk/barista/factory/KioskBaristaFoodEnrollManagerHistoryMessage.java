package coffee.order.view.output.kiosk.barista.factory;

import static coffee.order.view.output.OutputView.print;
import static coffee.order.view.output.UnitMessage.ENTER;
import static coffee.order.view.output.kiosk.barista.factory.KioskBaristaFoodEnrollManagerMessage.ANNOUNCE_ENROLL_FORM;

public class KioskBaristaFoodEnrollManagerHistoryMessage {

    public void askBaristaToEnrollForm() {
        print(ANNOUNCE_ENROLL_FORM.message + ENTER.unit);
    }
}
