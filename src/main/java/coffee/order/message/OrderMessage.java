package coffee.order.message;

public enum OrderMessage {

    AFTER_ORDER("주문 내역은 아래와 같습니다.\n"),
    TOTAL_PRICE("총 가격 : ");

    public final String message;

    OrderMessage(String message) {
        this.message = message;
    }
}
