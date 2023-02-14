package domain.selection;

import domain.cafe.Cafe;
import java.util.Arrays;
import java.util.function.Consumer;
import domain.selection.management.CouponHistoryManagement;
import domain.selection.management.MenuManagement;
import domain.selection.management.OrderHistoryManagement;
import domain.selection.management.PriceManagement;
import domain.selection.management.StockManagement;

public enum BaristaSelection {
    REGISTER_MENU(1, MenuManagement::registerMenu),
    SET_STOCK(2, StockManagement::setStock),
    CHANGE_PRICE(3, PriceManagement::changePrice),
    CHECK_ORDER_HISTORY(4, OrderHistoryManagement::checkOrderHistory),
    CHECK_COUPON_HISTORY(5, CouponHistoryManagement::checkCouponHistory);

    private final int value;

    private final Consumer<Cafe> manage;

    BaristaSelection(int value, Consumer<Cafe> manage) {
        this.value = value;
        this.manage = manage;
    }

    public static BaristaSelection getBaristaOption(int value) {
        return Arrays.stream(BaristaSelection.values())
                .filter(selection -> selection.value == value)
                .findAny()
                .orElseThrow(() ->
                        new IllegalArgumentException(value + "에 대응되는 Barista Selection이 없습니다")
                );
    }

    public void manage(Cafe cafe) {
        manage.accept(cafe);
    }
}
