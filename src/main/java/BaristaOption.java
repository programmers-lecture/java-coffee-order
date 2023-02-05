import java.util.Arrays;

public enum BaristaOption {
    REGISTER_MENU(1),
    SET_STOCK(2),
    CHANGE_PRICE(3),
    CHECK_ORDER_HISTORY(4),
    CHECK_COUPON_HISTORY(5);

    private final int value;

    BaristaOption(int value) {
        this.value = value;
    }

    public static BaristaOption getBaristaOption(int value) {
        return Arrays.asList(BaristaOption.values()).stream()
                .filter(baristaOption -> baristaOption.value == value)
                .findAny()
                .get();
    }
}
