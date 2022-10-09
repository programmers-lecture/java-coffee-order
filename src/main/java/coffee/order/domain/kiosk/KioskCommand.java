package coffee.order.domain.kiosk;

public enum KioskCommand {

    YES("1"),
    NO("2"),
    CUSTOMER("1"),
    BARISTA("2"),
    END_KIOSK("0");

    public final String code;

    KioskCommand(String code) {
        this.code = code;
    }
}