package coffee.order.view.output.order;

public enum OrdersMessage {

    ORDER_ASK_TO_CHOOSE_ORDER("사용할 메뉴를 골라주세요."),
    ORDER_TOTAL_PRICE("총 가격 : "),
    ORDER_COUPON_USE("쿠폰 사용");

    public final String message;

    OrdersMessage(String message) {
        this.message = message;
    }
}
