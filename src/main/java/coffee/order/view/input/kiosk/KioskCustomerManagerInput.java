package coffee.order.view.input.kiosk;

import static coffee.order.util.RegexUtil.REGEX_PHONE_NUMBER_FORM_VALIDATOR;
import static coffee.order.util.RegexUtil.checkFormValid;
import static coffee.order.view.input.InputView.read;
import static coffee.order.view.input.exception.KioskCouponManagerInputException.CUSTOMER_NOT_CORRECT_PHONE_NUMBER_FORM;

public class KioskCustomerManagerInput {

    public String askCustomerPhoneNumber() {
        String phoneNumber = read();
        if (checkPhoneNumberFormNotOk(phoneNumber)) {
            throw new IllegalArgumentException(CUSTOMER_NOT_CORRECT_PHONE_NUMBER_FORM.message);
        }
        return phoneNumber;
    }

    private boolean checkPhoneNumberFormNotOk(String phoneNumber) {
        return !checkFormValid(REGEX_PHONE_NUMBER_FORM_VALIDATOR, phoneNumber);
    }
}
