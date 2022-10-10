package coffee.order.view.input.kiosk.customer;

import static coffee.order.util.RegexUtil.REGEX_SELECT_MENU_FORM_VALIDATOR;
import static coffee.order.util.RegexUtil.checkFormValid;
import static coffee.order.view.input.InputView.read;
import static coffee.order.view.input.exception.kiosk.customer.KioskCustomerOrderManagerInputException.CUSTOMER_ORDER_ANSWER_EXCEPTION;

public class KioskCustomerOrderManagerInput {

    public String askCustomerToChooseFood() {
        String customerAnswered = read();
        if (customerAnswered == null ||
                !checkFormValid(REGEX_SELECT_MENU_FORM_VALIDATOR, customerAnswered)) {
            throw new IllegalArgumentException(CUSTOMER_ORDER_ANSWER_EXCEPTION.message);
        }
        return customerAnswered;
    }
}
