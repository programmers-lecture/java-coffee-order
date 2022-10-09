package coffee.order.view.output.kiosk.customer;

import coffee.order.domain.order.Order;

import java.util.Map;

import static coffee.order.view.output.OutputView.print;
import static coffee.order.view.output.UnitMessage.*;
import static coffee.order.view.output.kiosk.customer.KioskCustomerCouponManagerMessage.*;
import static coffee.order.view.output.order.OrdersMessage.ORDER_ASK_TO_CHOOSE_ORDER;

public class KioskCustomerCouponManagerHistoryMessage {

    public void printWhenAskSaveCoupon() {
        print(KIOSK_COUPON_ASK_SAVE_COUPON.message);
    }

    public void printWhenAskYesOrNo() {
        print(KIOSK_COUPON_SELECT_YES_OR_NO.message);
    }

    public void printCurrentCouponQuantity(String couponQuantity) {
        print(KIOSK_COUPON_NOTICE_CURRENT_COUPON_QUANTITY.message +
                couponQuantity +
                KIOSK_COUPON_NOTICE_CURRENT_COUPON_QUANTITY_LAST_SENTENCE.message);
    }

    public void printWhenAskUseCoupon() {
        print(KIOSK_COUPON_ASK_USE_COUPON.message);
    }

    public void printKioskToChoose() {
        print(ORDER_ASK_TO_CHOOSE_ORDER.message);
    }

    public void printToSelectMenuToApplyCoupon(Map<String, Order> myOrders) {
        StringBuilder ordersToChoiceBuilder = new StringBuilder();
        for (Map.Entry<String, Order> entry : myOrders.entrySet()) {
            ordersToChoiceBuilder
                    .append(entry.getKey())
                    .append(DOT.unit)
                    .append(SPACE.unit)
                    .append(entry.getValue().getFoodName())
                    .append(ENTER.unit);
        }
        print(ordersToChoiceBuilder.toString());
    }
}
