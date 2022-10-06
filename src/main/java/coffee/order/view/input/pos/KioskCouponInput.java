package coffee.order.view.input.pos;

import static coffee.order.domain.pos.KioskCommand.*;
import static coffee.order.view.input.InputView.*;
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
                (!customerAnswered.equals(YES.selectedCommand) &&
                        !customerAnswered.equals(NO.selectedCommand));
    }

    private boolean checkSelectMenuFormNotOk(String selectedMenu) {
        return selectedMenu == null || !selectedMenu.matches("^[0-9]*-[0-9]*$");
    }

    private boolean checkPhoneNumberFormNotOk(String phoneNumber) {
        return !phoneNumber.matches("^[0-9]{3}-[0-9]{4}-[0-9]{4}$");
    }

}
