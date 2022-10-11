package coffee.order.view.output.kiosk.customer;

import coffee.order.view.output.UnitMessage;

public enum KioskCustomerOrderManagerMessage {

    KIOSK_ORDER_INPUT_USER_SELECT("사용자를 선택하세요 " + UnitMessage.ENTER.unit + "1. 손님 / 2. 바리스타"),
    KIOSK_ORDER_AFTER_ORDER("주문 내역은 아래와 같습니다.");

    public final String message;

    KioskCustomerOrderManagerMessage(String message) {
        this.message = message;
    }
}
