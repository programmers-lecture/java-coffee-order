package coffee.order.view.input.exception;

public enum KioskBaristaInputException {

    KIOSK_BARISTA_INPUT_EXCEPTION("존재하지 않는 기능 입니다.");

    public final String message;

    KioskBaristaInputException(String message) {
        this.message = message;
    }
}
