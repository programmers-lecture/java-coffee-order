package coffee.order.message;

public enum KioskMessage {

    KIOSK_INPUT_USER_SELECT("\n사용자를 선택하세요\n1. 손님 / 2. 바리스타\n"),
    KIOSK_INPUT_CUSTOMER_SELECT_MENU("\n// 손님 선택 \n메뉴를 골라주세요 (번호, 개수)\n"),
    KIOSK_AFTER_ORDER("\n주문 내역은 아래와 같습니다.\n"),
    KIOSK_TOTAL_PRICE("총 가격 : "),
    KIOSK_FINISH_ORDER("\n주문 완료가 되었습니다.\n");

    public final String message;

    KioskMessage(String message) {
        this.message = message;
    }
}
