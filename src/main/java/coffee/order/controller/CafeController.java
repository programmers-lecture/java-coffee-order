package coffee.order.controller;

import coffee.order.domain.customer.Customer;
import coffee.order.domain.pos.Kiosk;
import coffee.order.view.input.controller.CafeControllerInput;
import coffee.order.view.output.controller.CafeControllerHistoryMessage;

import static coffee.order.domain.pos.KioskCommand.*;

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

            if (chosenOne.equals(END_KIOSK.selectedCommand)) {
                break;
            }

            if (chosenOne.equals(CUSTOMER.selectedCommand)) {
                Kiosk kiosk = new Kiosk();
                Customer customer = new Customer();
                kiosk.orderProcess(customer);
            }

            if (chosenOne.equals(BARISTA.selectedCommand)) {
                // TODO : 바리스타 구현 3주차
            }
        }

    }
}
