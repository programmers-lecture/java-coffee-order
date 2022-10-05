package coffee.order.view.output.pos;

public enum KioskOrderMessage {

    KIOSK_ORDER_INPUT_USER_SELECT("\n사용자를 선택하세요\n1. 손님 / 2. 바리스타\n"),
    KIOSK_ORDER_AFTER_ORDER("\n주문 내역은 아래와 같습니다.\n");

    public final String message;

    KioskOrderMessage(String message) {
        this.message = message;
    }
}
