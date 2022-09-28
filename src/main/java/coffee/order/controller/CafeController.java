package coffee.order.controller;

import coffee.order.domain.customer.Customer;
import coffee.order.domain.pos.Kiosk;
import coffee.order.view.InputView;

import static coffee.order.message.InputMessage.INPUT_USER_SELECT;
import static coffee.order.view.OutputView.print;

public class CafeController {

    public static void main(String[] args) {
        print(INPUT_USER_SELECT.message);
        String command = InputView.read();

        if (command.equals("1")) {
            Kiosk kiosk = new Kiosk();
            Customer customer = new Customer();
            kiosk.process(customer);

        }

        if (command.equals("2")) {

        }

    }
}
