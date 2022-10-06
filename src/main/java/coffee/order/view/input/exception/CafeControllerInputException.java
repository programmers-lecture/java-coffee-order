package coffee.order.view.input.exception;

public enum CafeControllerInputException {

    NO_SUCH_CHARACTER_EXCEPTION("입력하신 선택은 존재하지 않습니다.");

    public final String message;

    CafeControllerInputException(String message) {
        this.message = message;
    }
}
