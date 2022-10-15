package coffee.order.domain.kiosk.barista.factory;

import static coffee.order.domain.kiosk.barista.KioskBaristaMenus.*;
import static coffee.order.exception.KioskException.BARISTA_PROCESS_NULL_EXCEPTION;

public class KioskBaristaProcessFactory {

    private KioskBaristaProcessFactory() {
    }

    private static final KioskBaristaProcess foodInputManager = new KioskBaristaFoodEnrollManager();
    private static final KioskBaristaProcess foodQuantityManager = new KioskBaristaFoodQuantityManager();
    private static final KioskBaristaProcess foodPriceManager = new KioskBaristaFoodPriceManager();
    private static final KioskBaristaProcess receiptsTextManager = new KioskBaristaReceiptsTextManager();
    private static final KioskBaristaProcess receiptsCouponTextManager = new KioskBaristaCustomersCouponTextManager();

    public static KioskBaristaProcess find(String menu) {
        if (checkTypeCorrect(INPUT_FOOD, menu)) {
            return foodInputManager;
        }
        if (checkTypeCorrect(UPDATE_FOOD_QUANTITY, menu)) {
            return foodQuantityManager;
        }
        if (checkTypeCorrect(UPDATE_FOOD_PRICE, menu)) {
            return foodPriceManager;
        }
        if (checkTypeCorrect(SELECT_ORDERS_TEXT, menu)) {
            return receiptsTextManager;
        }
        if (checkTypeCorrect(SELECT_COUPON_ORDERS_TEXT, menu)) {
            return receiptsCouponTextManager;
        }
        throw new NullPointerException(BARISTA_PROCESS_NULL_EXCEPTION.message);
    }
}
