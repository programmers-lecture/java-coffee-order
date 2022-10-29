package coffee.order.view.output.kiosk.customer;

public enum KioskCustomerCustomerManagerMessage {

    KIOSK_ASK_PHONE_NUMBER("전화번호를 입력해주세요. (형식 : 000-0000-0000)");

    public final String message;

    KioskCustomerCustomerManagerMessage(String message) {
        this.message = message;
    }
}
