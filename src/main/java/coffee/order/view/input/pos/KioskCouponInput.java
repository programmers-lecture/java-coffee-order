package coffee.order.view.input.pos;

import static coffee.order.util.RegexUtil.*;
import static coffee.order.view.input.InputView.read;
import static coffee.order.view.input.exception.KioskCouponInputException.*;

public class KioskCouponInput {

    public String askCustomerYesOrNo() {
        String customerAnswered = read();
        if (checkAnswerFormNotOk(customerAnswered)) {
            throw new IllegalArgumentException(CUSTOMER_ANSWER_EXCEPTION.message);
        }
        return customerAnswered;
    }

    public String askCustomerMenuNumberToApplyCoupon() {
        String selectedMenu = read();
        if (checkSelectMenuFormNotOk(selectedMenu)) {
            throw new IllegalArgumentException(COUPON_APPLY_ANSWER_EXCEPTION.message);
        }
        return selectedMenu;
    }

    public String askCustomerPhoneNumber() {
        String phoneNumber = read();
        if (checkPhoneNumberFormNotOk(phoneNumber)) {
            throw new IllegalArgumentException(CUSTOMER_NOT_CORRECT_PHONE_NUMBER_FORM.message);
        }
        return phoneNumber;
    }

    private boolean checkAnswerFormNotOk(String customerAnswered) {
        return customerAnswered == null ||
                !checkFormValid(REGEX_YES_OR_NO_FORM_VALIDATOR, customerAnswered);
    }

    private boolean checkSelectMenuFormNotOk(String selectedMenu) {
        return selectedMenu == null ||
                !checkFormValid(REGEX_SELECT_MENU_FOR_COUPON_FORM_VALIDATOR, selectedMenu);
    }

    private boolean checkPhoneNumberFormNotOk(String phoneNumber) {
        return !checkFormValid(REGEX_PHONE_NUMBER_FORM_VALIDATOR, phoneNumber);
    }

}
