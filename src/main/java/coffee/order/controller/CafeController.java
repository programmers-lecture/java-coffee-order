package coffee.order.controller;

import coffee.order.domain.customer.Customer;
import coffee.order.domain.pos.Kiosk;
import coffee.order.view.input.InputView;
import coffee.order.view.output.controller.ControllerHistoryMessage;

import static coffee.order.domain.pos.KioskCommand.*;

public class CafeController {

    public ControllerHistoryMessage controllerHistory() {
        return new ControllerHistoryMessage();
    }

    public void openCafe() {
        while (true) {
            controllerHistory().printWhenAskUserSelect();
            String command = InputView.read();

            if (command.equals(END_KIOSK.selectedCommand)) {
                break;
            }

            if (command.equals(CUSTOMER.selectedCommand)) {
                Kiosk kiosk = new Kiosk();
                Customer customer = new Customer();
                kiosk.orderProcess(customer);
            }

            if (command.equals(BARISTA.selectedCommand)) {
                // TODO : 바리스타 구현 3주차
            }
        }

    }
}
