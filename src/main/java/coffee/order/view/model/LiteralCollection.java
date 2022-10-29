package coffee.order.view.model;

public enum LiteralCollection {
    BLANK(" "),
    COUNT("개"),
    WON("원"),
    HYPHEN("-"),
    DOT(".");

    private final String literal;

    LiteralCollection(String literal) {
        this.literal = literal;
    }

    public String getLiteral() {
        return literal;
    }
}
