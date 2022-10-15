package coffee.order.controller;

import coffee.order.domain.kiosk.Kiosk;
import coffee.order.view.input.controller.CafeControllerInput;
import coffee.order.view.output.controller.CafeControllerHistoryMessage;

import static coffee.order.domain.kiosk.KioskCommand.END_KIOSK;

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

            Kiosk kiosk = new Kiosk();
            kiosk.processKiosk(chosenOne);
        }
    }

}

