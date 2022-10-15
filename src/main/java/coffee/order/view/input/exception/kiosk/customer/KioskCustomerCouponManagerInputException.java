package coffee.order.view.input.exception.kiosk.customer;

public enum KioskCustomerCouponManagerInputException {

    COUPON_APPLY_ANSWER_EXCEPTION("쿠폰 사용 1(예) / 2(아니요) 입력 도중 오류가 발생하였습니다."),
    CUSTOMER_ANSWER_EXCEPTION("고객님의 입력 간에 오류가 발생하였습니다."),
    CUSTOMER_NOT_CORRECT_PHONE_NUMBER_FORM("존재할 수 없는 휴대폰 번호입123니다.");

    public final String message;

    KioskCustomerCouponManagerInputException(String message) {
        this.message = message;
    }
}
