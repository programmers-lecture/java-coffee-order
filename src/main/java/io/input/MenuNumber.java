package io.input;

public enum MenuNumber {
    FOR_ORDER(1), FOR_COUPON(2);

    private final int value;

    MenuNumber(int value) {
        this.value = value;
    }

    public int value() {
        return value;
    }
}
