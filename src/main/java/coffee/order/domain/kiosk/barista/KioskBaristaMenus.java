package coffee.order.domain.kiosk.barista;


import java.util.Arrays;

public enum KioskBaristaMenus {

    INPUT_FOOD("1", "커피 등록"),
    UPDATE_FOOD_QUANTITY("2", "수량 등록"),
    UPDATE_FOOD_PRICE("3", "가격 변경"),
    SELECT_ORDERS_TEXT("4", "주문 내역 확인"),
    SELECT_COUPON_ORDERS_TEXT("5", "쿠폰 내역 확인");


    public final String menuType;
    public final String menuName;

    KioskBaristaMenus(String menuType, String menuName) {
        this.menuType = menuType;
        this.menuName = menuName;
    }

    public static boolean checkTypeCorrect(KioskBaristaMenus menu, String selectMenu) {
        return menu.menuType.equals(selectMenu);
    }

    public static boolean checkMenuExists(String selectMenu) {
        return Arrays.stream(KioskBaristaMenus.values())
                .anyMatch(menu -> menu.menuType.equals(selectMenu));
    }
}
