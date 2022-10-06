package coffee.order.view.output.pos;

import coffee.order.domain.order.Order;

import java.util.Map;

import static coffee.order.view.output.OutputView.print;
import static coffee.order.view.output.order.OrdersMessage.ORDER_ASK_TO_CHOOSE_ORDER;
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

    public void printKioskToChoose() {
        print(ORDER_ASK_TO_CHOOSE_ORDER.message);
    }

    public void printToSelectMenuToApplyCoupon(Map<String, Order> myOrders) {
        StringBuilder ordersToChoiceBuilder = new StringBuilder();
        for (Map.Entry<String, Order> entry : myOrders.entrySet()) {
            ordersToChoiceBuilder
                    .append(entry.getKey())
                    .append(". ")
                    .append(entry.getValue().getFoodName())
                    .append("\n");
        }
        print(ordersToChoiceBuilder.toString());
    }
}
