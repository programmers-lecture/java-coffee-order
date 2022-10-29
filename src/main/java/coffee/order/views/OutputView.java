package coffee.order.views;

import java.util.List;

import static coffee.order.common.Constants.*;

public class OutputView {
    private OutputView() {}

    public static void printMenuSelect() {
        System.out.println(SELECT_ORDER_MENU_REQUEST);
    }

    public static void printMenuCategory(int number, String category) {
        System.out.println(number + ". " + category);
    }

    public static void printMenuFoods(List<String> menuFoods) {
        for(String menuFood: menuFoods)
            System.out.println(menuFood);
        System.out.println(MENU_CATEGORY_UNDERLINE);
    }

    public static void printOrdersStart() {
        System.out.println(ORDER_MENU_PRINT);
    }

    public static void printOrdersInfo(List<String> orders) {
        for(String order: orders) {
            System.out.println(order);
        }
    }

    public static void printTotalPriceSum(int totalPriceSum) {
        System.out.println();
        System.out.println(String.format(TOTAL_PRICE_PRINT, totalPriceSum));
        System.out.println();
    }

    public static void printCouponCnt(int couponCnt) {
        System.out.println();
        System.out.println(String.format(COUPONS_COUNT_PRINT, couponCnt));
        System.out.println();
    }

    public static void printCouponUse() {
        System.out.println();
        System.out.println(COUPON_USE_END_PRINT);
        System.out.println();
    }

    public static void printOrderEnd() {
        System.out.println(ORDER_END_PRINT);
        System.out.println();
    }
}
