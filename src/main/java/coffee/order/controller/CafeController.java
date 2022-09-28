package coffee.order.controller;

import coffee.order.domain.customer.Customer;
import coffee.order.domain.pos.Kiosk;
import coffee.order.view.InputView;

import static coffee.order.domain.pos.KioskCommand.*;
import static coffee.order.message.KioskMessage.KIOSK_INPUT_USER_SELECT;
import static coffee.order.view.OutputView.print;

public class CafeController {

    public static void main(String[] args) {
        while (true) {
            print(KIOSK_INPUT_USER_SELECT.message);
            String command = InputView.read();

            if (command.equals(END_KIOSK.selectedCommand)) {
                break;
            }

            if (command.equals(CUSTOMER.selectedCommand)) {
                Kiosk kiosk = new Kiosk();
                Customer customer = new Customer();
                kiosk.process(customer);
            }

            if (command.equals(BARISTA.selectedCommand)) {
                // TODO : 바리스타 구현 3주차
            }
        }

    }
}
