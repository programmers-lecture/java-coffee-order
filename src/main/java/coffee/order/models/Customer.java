package coffee.order.models;

import java.util.regex.Pattern;

public class Customer {
    private String phoneNumber;

    public Customer() {}

    public void addPhoneNumberInfo(String phoneNumber) {
        String regEx = "(\\d{3})-(\\d{4})-(\\d{4})";
        if(!Pattern.matches(regEx, phoneNumber)){
           throw new IllegalArgumentException("전화번호 형식이 알맞지 않습니다.");
        }
        this.phoneNumber = phoneNumber;
    }

    @Override
    public boolean equals(Object obj) {
        return this == obj || (this.phoneNumber.equals(((Customer) obj).phoneNumber));
    }

    @Override
    public int hashCode() {
        return phoneNumber.hashCode();
    }

    public boolean isSameObject(Object obj) {
        return this == obj;
    }
}
