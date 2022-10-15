package coffee.order.view.input.exception.kiosk.barista.factory;

public enum KioskBaristaFoodQuantityManagerInputException {

    MENU_AND_FOOD_QUANTITY_UPDATE_FORM_EXCEPTION("업데이트하기 위한 상품 번호와 상품 수량 포맷 입력에서 오류가 발생하였습니다.");

    public final String message;

    KioskBaristaFoodQuantityManagerInputException(String message) {
        this.message = message;
    }
}
