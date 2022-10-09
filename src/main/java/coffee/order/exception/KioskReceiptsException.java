package coffee.order.exception;

public enum KioskReceiptsException {

    RECEIPT_NULL_EXCEPTION("어떠한 영수증도 존재하지 않습니다.");

    public final String message;

    KioskReceiptsException(String message) {
        this.message = message;
    }
}
