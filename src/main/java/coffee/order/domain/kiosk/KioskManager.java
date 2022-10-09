package coffee.order.domain.kiosk;

import coffee.order.domain.kiosk.customer.KioskCustomer;

public class KioskManager {

    public void processCustomer() {
        KioskCustomer kioskCustomer = new KioskCustomer();
        kioskCustomer.processOrder();
        kioskCustomer.processCoupon();
        kioskCustomer.giveReceipt();
    }

    /**
     * 바리스타
     */

    // TODO : 커피 등록 요청

    // TODO : 수량 등록 요청

    // TODO : 가격 변경 요청

    // TODO : 주문 내역 출력 요청

    // TODO : 쿠폰 내역 출력 요청
}
