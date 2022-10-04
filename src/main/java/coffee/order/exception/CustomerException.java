package coffee.order.exception;

public enum CustomerException {

    CUSTOMER_NOT_ENOUGH_MONEY("고객님의 현금이 부족합니다."),
    CUSTOMER_NO_SUCH_PHONE_NUMBER("등록되지 않은 휴대폰 번호입니다."),
    CUSTOMER_NOT_CORRECT_PHONE_NUMBER_FORM("존재할 수 없는 휴대폰 번호입니다."),
    CUSTOMER_NOT_EXIST_ORDER_FOOD_NUMBER("존재하지 않는 주문 상품 번호입니다.");

    private final String message;

    CustomerException(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
