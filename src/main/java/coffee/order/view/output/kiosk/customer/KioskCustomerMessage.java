package coffee.order.view.output.kiosk.customer;

public enum KioskCustomerMessage {

    KIOSK_AFTER_ORDER("\n주문 내역은 아래와 같습니다.\n"),
    KIOSK_FINISH_ORDER("\n주문 완료 되었습니다.\n");

    public final String message;

    KioskCustomerMessage(String message) {
        this.message = message;
    }
}
