package coffee.order.view.output.kiosk.barista.factory;

public enum KioskBaristaFoodPriceManagerMessage {

    ANNOUNCE_MENU_AND_FOOD_PRICE_FORM("번호와 가격을 선택해주세요. (ex) 1-1, 2500)"),
    ANNOUNCE_UPDATE_FINISHED("입력이 완료 되었습니다.");

    public final String message;

    KioskBaristaFoodPriceManagerMessage(String message) {
        this.message = message;
    }
}
