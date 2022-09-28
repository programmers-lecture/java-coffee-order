package coffee.order.exception;

public enum FoodCategoryException {

    FOODS_GET_NULL_POINTER_EXCEPTION(new NullPointerException("등록되지 않은 상품입니다."));

    private final RuntimeException exception;

    FoodCategoryException(RuntimeException exception) {
        this.exception = exception;
    }

    public RuntimeException throwMyException() {
        return this.exception;
    }

}
