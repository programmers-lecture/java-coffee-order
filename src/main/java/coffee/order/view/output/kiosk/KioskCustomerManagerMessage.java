package coffee.order.view.output.kiosk;

public enum KioskCustomerManagerMessage {

    KIOSK_ASK_PHONE_NUMBER("\n전화번호를 입력해주세요. (형식 : 000-0000-0000)\n");

    public final String message;

    KioskCustomerManagerMessage(String message) {
        this.message = message;
    }
}
