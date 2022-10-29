package coffee.order.view.output.kiosk.barista;

public enum KioskBaristaMessage {

    KIOSK_BARISTA_ASK_SELECT_MENU("사용할 메뉴를 선택하세요.");

    public final String message;

    KioskBaristaMessage(String message) {
        this.message = message;
    }
}
