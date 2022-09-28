package coffee.order.controller;

import coffee.order.domain.customer.Customer;
import coffee.order.domain.pos.Kiosk;
import coffee.order.message.InputMessage;
import coffee.order.view.InputView;
import coffee.order.view.OutputView;

import static coffee.order.message.InputMessage.*;
import static coffee.order.view.OutputView.*;

public class CafeController {

    public static void main(String[] args) {
        print(INPUT_USER_SELECT.message);
        String command = InputView.read();

        if (command.equals("1")) {
            Kiosk kiosk = new Kiosk();
            Customer customer = new Customer();
            kiosk.takeOrders(customer);

        }

        if (command.equals("2")) {

        }

    }
}
