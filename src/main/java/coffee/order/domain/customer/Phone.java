package coffee.order.domain.customer;

import coffee.order.dto.customer.PhoneDto;

import static coffee.order.exception.CustomerException.CUSTOMER_NOT_CORRECT_PHONE_NUMBER_FORM;
import static coffee.order.util.RegexUtil.REGEX_PHONE_NUMBER_FORM_VALIDATOR;
import static coffee.order.util.RegexUtil.checkFormValid;

public class Phone {

    private String phoneNumber;

    public Phone() {
        phoneNumber = "000-0000-0000";
    }

    public Phone(String phoneNumber) {
        if (checkPhoneNumberEmpty(phoneNumber) || !checkPhoneNumberForm(phoneNumber)) {
            throw new IllegalArgumentException(CUSTOMER_NOT_CORRECT_PHONE_NUMBER_FORM.getMessage());
        }
        this.phoneNumber = phoneNumber;
    }

    public PhoneDto toPhoneDto() {
        return new PhoneDto(phoneNumber);
    }

    private boolean checkPhoneNumberEmpty(String phoneNumber) {
        return phoneNumber.length() == 0;
    }

    private boolean checkPhoneNumberForm(String phoneNumber) {
        return checkFormValid(REGEX_PHONE_NUMBER_FORM_VALIDATOR, phoneNumber);
    }

    public String loadPhoneNumber() {
        return phoneNumber;
    }
}
