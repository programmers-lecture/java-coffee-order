package coffee.order.view.output.kiosk.customer;

public enum KioskCustomerCouponManagerMessage {

    KIOSK_COUPON_ASK_SAVE_COUPON("\n쿠폰을 적립하시겠습니까?\n"),
    KIOSK_COUPON_SELECT_YES_OR_NO("\n1. 네 / 2. 아니요\n"),
    KIOSK_COUPON_NOTICE_CURRENT_COUPON_QUANTITY("\n현재 쿠폰 개수는 "),
    KIOSK_COUPON_NOTICE_CURRENT_COUPON_QUANTITY_LAST_SENTENCE(" 입니다. \n"),
    KIOSK_COUPON_ASK_USE_COUPON("\n쿠폰을 사용하시겠습니까?\n");

    public final String message;

    KioskCustomerCouponManagerMessage(String message) {
        this.message = message;
    }

}
