package coffee.order.domain.pos;

public enum KioskCommand {

    YES("1"),
    NO("2"),
    CUSTOMER("1"),
    BARISTA("2");

    public final String selectedCommand;

    KioskCommand(String selectedCommand) {
        this.selectedCommand = selectedCommand;
    }
}