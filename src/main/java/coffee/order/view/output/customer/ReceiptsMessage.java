package coffee.order.view.output.customer;

public enum ReceiptsMessage {

    RECEIPT_AFTER_ORDER("\n주문 내역은 아래와 같습니다.\n"),
    RECEIPT_FINISH_ORDER("\n주문 완료 되었습니다.\n");

    public final String message;

    ReceiptsMessage(String message) {
        this.message = message;
    }
}
