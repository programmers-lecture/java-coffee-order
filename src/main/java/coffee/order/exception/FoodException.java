package coffee.order.exception;

public enum FoodException {

    PRICE_MINUS_EXCEPTION(new IllegalArgumentException("상품 가격은 음수가 될 수 없습니다.")),
    QUANTITY_MINUS_EXCEPTION(new IllegalArgumentException("상품 수량은 음수가 될 수 없습니다.")),;

    private final RuntimeException exception;

    FoodException(RuntimeException exception) {
        this.exception = exception;
    }

    public RuntimeException throwMyException() {
        return this.exception;
    }

}
