package coffee.order.view.output;

public enum UnitMessage {

    COUNT("개"),
    WON("원"),
    SLASH("/"),
    RIGHT_ARROW("->"),
    SPACE(" "),
    TOTAL("총"),
    ENTER("\n"),
    DOT(".");

    public final String unit;

    UnitMessage(String unit) {
        this.unit = unit;
    }

}
