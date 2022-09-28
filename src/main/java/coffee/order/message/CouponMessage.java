package coffee.order.message;

public enum CouponMessage {

    KIOSK_ASK_SAVE_COUPON("쿠폰을 적립하시겠습니까?\n"),
    KIOSK_SELECT_YES_OR_NO("1. 네 / 2. 아니요\n"),
    KIOSK_NOTICE_CURRENT_COUPON_QUANTITY("현재 쿠폰 갯수는"),
    KIOSK_NOTICE_CURRENT_COUPON_QUANTITY_LAST_SENTENCE(" 입니다. \n"),
    KIOSK_ASK_USE_COUPON("쿠폰을 사용하시겠습니까?\n"),
    KIOSK_ASK_PHONE_NUMBER("전화번호를 입력해주세요. (형식 : 000-0000-0000)\n");

    public final String message;

    CouponMessage(String message) {
        this.message = message;
    }

}
