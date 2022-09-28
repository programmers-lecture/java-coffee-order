package coffee.order.exception;

public enum PriceException {

    PRICE_MINUS_EXCEPTION(new IllegalArgumentException("상품 가격은 음수가 될 수 없습니다."));

    private final RuntimeException exception;

    PriceException(RuntimeException exception) {
        this.exception = exception;
    }

    public RuntimeException throwMyException() {
        return this.exception;
    }

}
