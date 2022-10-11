package coffee.order.view.output.kiosk.customer;

public enum KioskCustomerCouponManagerMessage {

    KIOSK_COUPON_ASK_SAVE_COUPON("쿠폰을 적립하시겠습니까?"),
    KIOSK_COUPON_SELECT_YES_OR_NO("1. 네 / 2. 아니요"),
    KIOSK_COUPON_NOTICE_CURRENT_COUPON_QUANTITY("현재 쿠폰 개수는 "),
    KIOSK_COUPON_NOTICE_CURRENT_COUPON_QUANTITY_LAST_SENTENCE(" 입니다."),
    KIOSK_COUPON_ASK_USE_COUPON("쿠폰을 사용하시겠습니까?");

    public final String message;

    KioskCustomerCouponManagerMessage(String message) {
        this.message = message;
    }

}
