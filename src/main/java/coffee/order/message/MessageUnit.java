package coffee.order.message;

public enum MessageUnit {

    COUNT("개"),
    WON("원");

    public final String unit;

    MessageUnit(String unit) {
        this.unit = unit;
    }

}
