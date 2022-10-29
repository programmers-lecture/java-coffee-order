package coffee.order.exception;

public enum FoodException {
    FOOD_CATEGORY_GET_NULL_POINTER_EXCEPTION("등록되지 않은 상품 카테고리입니다."),
    FOODS_GET_NULL_POINTER_EXCEPTION("등록되지 않은 상품입니다."),
    PRICE_MINUS_EXCEPTION("상품 가격은 음수가 될 수 없습니다."),
    QUANTITY_MINUS_EXCEPTION("상품 수량은 음수가 될 수 없습니다."),
    FOOD_ENROLL_ALREADY_EXISTS_EXCEPTION("해당 상품 번호는 이미 존재하여 등록할 수 없습니다.");

    private final String message;

    FoodException(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
