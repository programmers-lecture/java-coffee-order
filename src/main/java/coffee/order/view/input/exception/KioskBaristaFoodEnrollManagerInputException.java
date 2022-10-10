package coffee.order.view.input.exception;

public enum KioskBaristaFoodEnrollManagerInputException {

    FOOD_ENROLL_FORM_EXCEPTION("상품 등록 포맷에서 오류가 발생하였습니다.");

    public final String message;

    KioskBaristaFoodEnrollManagerInputException(String message) {
        this.message = message;
    }
}
