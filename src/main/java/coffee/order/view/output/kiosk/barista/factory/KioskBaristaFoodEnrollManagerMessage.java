package coffee.order.view.output.kiosk.barista.factory;

public enum KioskBaristaFoodEnrollManagerMessage {

    ANNOUNCE_ENROLL_FORM("번호와 이름, 가격을 입력해주세요. (ex) 커피, 1-1. 에스프레소, 2000");

    public final String message;

    KioskBaristaFoodEnrollManagerMessage(String message) {
        this.message = message;
    }

}
