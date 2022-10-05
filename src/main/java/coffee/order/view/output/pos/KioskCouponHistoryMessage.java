package coffee.order.view.output.pos;

import static coffee.order.view.output.OutputView.print;
import static coffee.order.view.output.pos.KioskCouponMessage.*;

public class KioskCouponHistoryMessage {

    public void printWhenAskSaveCoupon() {
        print(KIOSK_COUPON_ASK_SAVE_COUPON.message);
    }

    public void printWhenAskYesOrNo() {
        print(KIOSK_COUPON_SELECT_YES_OR_NO.message);
    }

    public void printWhenNoticeCurrentCouponQuantity() {
        print(KIOSK_COUPON_NOTICE_CURRENT_COUPON_QUANTITY.message);
    }

    public void printCurrentCouponQuantity(String couponQuantity) {
        print(couponQuantity);
    }

    public void printAfterNoticeCurrentCouponQuantity() {
        print(KIOSK_COUPON_NOTICE_CURRENT_COUPON_QUANTITY_LAST_SENTENCE.message);
    }

    public void printWhenAskUseCoupon() {
        print(KIOSK_COUPON_ASK_USE_COUPON.message);
    }

    public void printWhenAskPhoneNumber() {
        print(KIOSK_COUPON_ASK_PHONE_NUMBER.message);
    }
}
