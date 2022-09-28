package coffee.order.domain.customer;

public class Phone {

    private String phoneNumber;

    public Phone(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    private boolean checkPhoneNumberForm(String phoneNumber) {
        // TODO : 정규 표현식을 이용하여 핸드폰 번호 형식 검증
        return false;
    }
}
