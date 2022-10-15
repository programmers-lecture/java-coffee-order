package coffee.order.dto.customer;

public class PhoneDto {

    private final String phoneNumber;

    public PhoneDto(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }
}
