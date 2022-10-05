package coffee.order.view.output;

public enum UnitMessage {

    COUNT("개"),
    WON("원");

    public final String unit;

    UnitMessage(String unit) {
        this.unit = unit;
    }

}
