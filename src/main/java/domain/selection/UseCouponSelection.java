package domain.selection;

import java.util.Arrays;

public enum UseCouponSelection {
    YES(1), NO(2);

    private final int value;

    UseCouponSelection(int value) {
        this.value = value;
    }

    public static UseCouponSelection getApplyCouponSelection(int value) {
        return Arrays.stream(UseCouponSelection.values())
                .filter(selection -> selection.value == value)
                .findAny()
                .orElseThrow(() ->
                        new IllegalArgumentException(value + "에 대응되는 ApplyCouponSelection이 없습니다")
                );
    }
}
