package coffee.order.domain.customer;

import coffee.order.dto.customer.PhoneDto;

import static coffee.order.exception.CustomerException.CUSTOMER_NOT_CORRECT_PHONE_NUMBER_FORM;

public class Phone {

    private String phoneNumber;

    public Phone() {
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
        return phoneNumber.matches("^[0-9]{3}-[0-9]{4}-[0-9]{4}$");
    }

    public String loadPhoneNumber() {
        return phoneNumber;
    }
}
