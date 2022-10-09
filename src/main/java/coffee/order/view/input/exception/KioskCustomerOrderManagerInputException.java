package coffee.order.view.input.exception;

public enum KioskCustomerOrderManagerInputException {

    CUSTOMER_ORDER_ANSWER_EXCEPTION("고객님의 주문 입력 간에 오류가 발생하였습니다.");

    public final String message;

    KioskCustomerOrderManagerInputException(String message) {
        this.message = message;
    }
}
