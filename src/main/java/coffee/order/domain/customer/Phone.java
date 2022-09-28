package coffee.order.domain.customer;

import static coffee.order.exception.CustomerException.CUSTOMER_NOT_CORRECT_PHONE_NUMBER_FORM;

public class Phone {

    private String phoneNumber;

    public Phone() {
    }

    public Phone(String phoneNumber) {
        if (checkPhoneNumberEmpty(phoneNumber) || !checkPhoneNumberForm(phoneNumber)) {
            throw CUSTOMER_NOT_CORRECT_PHONE_NUMBER_FORM.throwMyException();
        }
        this.phoneNumber = phoneNumber;
    }

    private boolean checkPhoneNumberEmpty(String phoneNumber) {
        return phoneNumber.length() == 0;
    }

    private boolean checkPhoneNumberForm(String phoneNumber) {
        return phoneNumber.matches("^000-[0-9]{4}-[0-9]{4}");
    }
}
