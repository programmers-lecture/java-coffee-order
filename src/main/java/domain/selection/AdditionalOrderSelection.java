package domain.selection;

import java.util.Arrays;

public enum AdditionalOrderSelection {
    YES(1), NO(2);

    private final int value;

    AdditionalOrderSelection(int value) {
        this.value = value;
    }

    public static AdditionalOrderSelection getAdditionalOrder(int value) {
        return Arrays.stream(AdditionalOrderSelection.values())
                .filter(selection -> selection.value == value)
                .findAny()
                .orElseThrow(() ->
                        new IllegalArgumentException(value + "에 대응되는 Additional Order Selection이 없습니다")
                );
    }
}
