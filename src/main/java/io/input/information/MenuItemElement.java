package io.input.information;

public enum MenuItemElement {
    CATEGORY_NUMBER(0),
    CATEGORY_NAME(1),
    ORDER_COUNT(2),
    MENU_NUMBER(3),
    MENU_NAME(4),
    MENU_PRICE(5);

    private final int value;

    MenuItemElement(int value) {
        this.value = value;
    }

    public int value() {
        return value;
    }
}
