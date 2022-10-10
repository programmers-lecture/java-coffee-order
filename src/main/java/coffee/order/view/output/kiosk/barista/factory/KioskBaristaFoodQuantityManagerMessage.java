package coffee.order.view.output.kiosk.barista.factory;

public enum KioskBaristaFoodQuantityManagerMessage {

    ANNOUNCE_MENU_AND_FOOD_QUANTITY_FORM("번호와 수량을 선택해주세요. (ex) 1-1, 10)"),
    ANNOUNCE_UPDATE_FINISHED("입력이 완료 되었습니다.");

    public final String message;

    KioskBaristaFoodQuantityManagerMessage(String message) {
        this.message = message;
    }
}
