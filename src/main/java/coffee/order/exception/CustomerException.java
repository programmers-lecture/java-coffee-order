package coffee.order.exception;

public enum CustomerException {

    CUSTOMER_NOT_ENOUGH_MONEY(new IllegalArgumentException("고객님의 현금이 부족합니다.")),
    CUSTOMER_NO_SUCH_PHONE_NUMBER(new NullPointerException("등록되지 않은 휴대폰 번호입니다."));

    private final RuntimeException exception;

    CustomerException(RuntimeException exception) {
        this.exception = exception;
    }

    public RuntimeException throwMyException() {
        return this.exception;
    }

}
