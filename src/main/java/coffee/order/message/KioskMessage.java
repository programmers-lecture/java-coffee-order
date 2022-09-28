package coffee.order.message;

public enum KioskMessage {

    KIOSK_INPUT_USER_SELECT("사용자를 선택하세요\n1. 손님 / 2. 바리스타"),
    KIOSK_INPUT_CUSTOMER_SELECT_MENU("// 손님 선택 \n메뉴를 골라주세요 (번호, 개수)"),
    KIOSK_AFTER_ORDER("주문 내역은 아래와 같습니다.\n"),
    KIOSK_TOTAL_PRICE("총 가격 : ");

    public final String message;

    KioskMessage(String message) {
        this.message = message;
    }
}
