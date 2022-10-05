package coffee.order.view.output.pos;

public enum KioskCouponMessage {

    KIOSK_COUPON_ASK_PHONE_NUMBER("\n전화번호를 입력해주세요. (형식 : 000-0000-0000)\n"),
    KIOSK_COUPON_ASK_SAVE_COUPON("\n쿠폰을 적립하시겠습니까?\n"),
    KIOSK_COUPON_SELECT_YES_OR_NO("\n1. 네 / 2. 아니요\n"),
    KIOSK_COUPON_NOTICE_CURRENT_COUPON_QUANTITY("\n현재 쿠폰 개수는 "),
    KIOSK_COUPON_NOTICE_CURRENT_COUPON_QUANTITY_LAST_SENTENCE(" 입니다. \n"),
    KIOSK_COUPON_ASK_USE_COUPON("\n쿠폰을 사용하시겠습니까?\n");

    public final String message;

    KioskCouponMessage(String message) {
        this.message = message;
    }

}
