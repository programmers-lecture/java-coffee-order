package coffee.order.controller;

import coffee.order.domain.kiosk.Kiosk;
import coffee.order.view.input.controller.CafeControllerInput;
import coffee.order.view.output.controller.CafeControllerHistoryMessage;

import static coffee.order.domain.kiosk.KioskCommand.*;

public class CafeController {

    public CafeControllerHistoryMessage controllerHistory() {
        return new CafeControllerHistoryMessage();
    }

    public CafeControllerInput cafeControllerInput() {
        return new CafeControllerInput();
    }

    public void openCafe() {
        while (true) {
            controllerHistory().printWhenAskUserSelect();
            String chosenOne = cafeControllerInput().askCustomerOrBarista();

            if (chosenOne.equals(END_KIOSK.code)) {
                break;
            }

            if (chosenOne.equals(CUSTOMER.code)) {
                Kiosk kiosk = new Kiosk();
                kiosk.processKiosk(CUSTOMER.code);
            }

            if (chosenOne.equals(BARISTA.code)) {
                // TODO : 바리스타 구현 3주차
            }
        }

    }
}
