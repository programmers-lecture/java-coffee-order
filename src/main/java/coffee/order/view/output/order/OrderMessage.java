package coffee.order.view.output.order;

public enum OrderMessage {

    ORDER_COUPON_USE("쿠폰 사용");

    public final String message;

    OrderMessage(String message) {
        this.message = message;
    }
}
