package coffee.order.domain.kiosk.barista;

public class KioskBarista {

    private final KioskBaristaFoodManager foodManager;
    private final KioskBaristaOrderManager orderManager;
    private final KioskBaristaCouponManager couponManager;

    public KioskBarista() {
        this.foodManager = new KioskBaristaFoodManager();
        this.orderManager = new KioskBaristaOrderManager();
        this.couponManager = new KioskBaristaCouponManager();
    }

    // TODO : 커피 등록 요청

    // TODO : 수량 등록 요청

    // TODO : 가격 변경 요청

    // TODO : 주문 내역 출력 요청

    // TODO : 쿠폰 내역 출력 요청
}
