package domain.selection;

import java.util.Arrays;

public enum UserSelection {
    EXIT(0), CUSTOMER(1), BARISTA(2);

    private final int value;

    UserSelection(int value) {
        this.value = value;
    }

    public static UserSelection getUserOption(int value) {
        return Arrays.stream(UserSelection.values())
                .filter(selection -> selection.value == value)
                .findAny()
                .orElseThrow(() ->
                        new IllegalArgumentException(value + "에 대응되는 User Selection이 없습니다")
                );
    }
}
