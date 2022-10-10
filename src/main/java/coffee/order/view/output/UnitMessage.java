package coffee.order.view.output;

public enum UnitMessage {

    COUNT("개"),
    WON("원"),
    SLASH("/"),
    RIGHT_ARROW("->"),
    SPACE(" "),
    TOTAL("총"),
    ENTER("\n"),
    DOT("."),
    LEFT_BRACKET("("),
    RIGHT_BRACKET(")"),
    COUPON_USED("쿠폰 사용"),
    MIDDLE_LINE("-");

    public final String unit;

    UnitMessage(String unit) {
        this.unit = unit;
    }

}
