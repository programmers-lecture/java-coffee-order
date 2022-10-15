package coffee.order.exception;

public enum KioskException {

    BARISTA_PROCESS_NULL_EXCEPTION("존재하지 않는 바리스타 기능입니다."),
    RECEIPT_NULL_EXCEPTION("어떠한 영수증도 존재하지 않습니다.");

    public final String message;

    KioskException(String message) {
        this.message = message;
    }
}
