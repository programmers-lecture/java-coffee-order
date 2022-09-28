package coffee.order.exception;

public enum FoodsException {

    FOODS_GET_NULL_POINTER_EXCEPTION("등록되지 않은 상품입니다.");

    private final String message;

    FoodsException(String message) {
        this.message = message;
    }

    public RuntimeException throwMyException() {
        return new RuntimeException(this.message);
    }
}
