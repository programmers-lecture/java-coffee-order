package coffee.order.view;

import coffee.order.model.Menu;
import coffee.order.model.MenuType;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class OutputView {
    private static final String GREETING = "Welcome! 손님 역할을 실행합니다...";
    private static final String MENU_GUIDE = "메뉴를 골라주세요 (번호, 개수)";
    private static final String PHONE_NUMBER_GUIDE = "전화번호를 입력해주세요. (형식 : 000-0000-0000)";
    private static final String ORDER_CONFIRM = "주문 내역은 아래와 같습니다.";
    private static final String YES_OR_NO = "1. 네 / 2. 아니요";

    private static final String COUPON_ACCUMULATION_CONFIRM = "쿠폰을 적립하시겠습니까?";
    private static final String COUPON_APPLICATION_CONFIRM = "쿠폰을 사용하시겠습니까?";
    private static final String COUPON_QUANTITY_NOTIFICATION = "현재 쿠폰의 개수는 %d개 입니다.";

    private static final String HYPHEN = "-";
    private static final String BLANK = " ";
    private static final String MENU_TYPE_DELIMITER = ". ";
    private static final int INDEX_BOUNDARY = 1;

    public void printGreetingMessage() {
        System.out.println(GREETING);
        System.out.println();
    }

    public void printMenu(MenuType[] menuTypes, HashMap<MenuType, ArrayList<? super Menu>> menuDatabase) {
        System.out.println(MENU_GUIDE);

        for (MenuType menuType : menuTypes) {
            System.out.println(menuTypeFormat(menuType));

            ArrayList<? super Menu> menuList = menuDatabase.get(menuType);
            menuList.forEach(menu -> System.out.println(menuFormat(menuType, menuList, menu)));
            System.out.println();
        }
    }

    private String menuTypeFormat(MenuType menuType) {
        return menuType.getMenuTypeIndex() + MENU_TYPE_DELIMITER + menuType.getKoreanName();
    }

    private String menuFormat(MenuType menuType, ArrayList<? super Menu> menuList, Object menu) {
        return menuIndexGenerator(menuType, menuList, menu) + BLANK + menu.toString();
    }

    private String menuIndexGenerator(MenuType menuType, ArrayList<? super Menu> menuList, Object menu) {
        return menuType.getMenuTypeIndex() + HYPHEN + (menuList.indexOf(menu) + INDEX_BOUNDARY);
    }

    public void confirmOrder(List<String> orderLiteral) {
        System.out.println(ORDER_CONFIRM);
        orderLiteral.forEach(System.out::println);
        System.out.println();
    }

    public void printCouponConfirmMessage() {
        System.out.println(COUPON_ACCUMULATION_CONFIRM);
        System.out.println(YES_OR_NO);
    }

    public void printPhoneNumberGuideMessage() {
        System.out.println(PHONE_NUMBER_GUIDE);
    }

    public void printCouponQuatity(Integer couponQuantity) {
        System.out.println(generateCouponQuantityNotifyingMessage(couponQuantity));
    }

    private String generateCouponQuantityNotifyingMessage(Integer couponQuantity) {
        return String.format(COUPON_QUANTITY_NOTIFICATION, couponQuantity);
    }

    public void printCouponApplicationConfirm() {
        System.out.println(COUPON_APPLICATION_CONFIRM);
        System.out.println(YES_OR_NO);
    }
}
