package coffee.order.view.output;

public enum UnitMessage {

    COUNT("개"),
    COUPON_USED("쿠폰 사용"),
    COMMA(","),
    DOT("."),
    ENTER("\n"),
    LEFT_BRACKET("("),
    SPACE(" "),
    SLASH("/"),
    MIDDLE_LINE("-"),
    TOTAL("총"),
    RIGHT_BRACKET(")"),
    RIGHT_ARROW("->"),
    WON("원");

    public final String unit;

    UnitMessage(String unit) {
        this.unit = unit;
    }

}
