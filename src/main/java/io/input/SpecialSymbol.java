package io.input;

public enum SpecialSymbol {
    COMMA(","), PERIOD("."), SPACE(" "), HYPHEN("-");

    private final String symbol;

    SpecialSymbol(String symbol) {
        this.symbol = symbol;
    }

    public String symbol() {
        return symbol;
    }
}
