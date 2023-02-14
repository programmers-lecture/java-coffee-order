package domain.selection;

import java.util.Arrays;

public enum EarnCouponSelection {
    YES(1), NO(2);

    private final int value;

    EarnCouponSelection(int value) {
        this.value = value;
    }

    public static EarnCouponSelection getEarnCouponSelection(int value) {
        return Arrays.stream(EarnCouponSelection.values())
                .filter(selection -> selection.value == value)
                .findAny()
                .orElseThrow(() ->
                        new IllegalArgumentException(value + "에 대응되는 EarnCouponSelection이 없습니다")
                );
    }
}
