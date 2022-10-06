package coffee.order.views;

import java.util.List;

public class OutputView {
    private OutputView() {}

    public static void printMenuSelect() {
        System.out.println("메뉴를 골라주세요 (번호, 갯수)");
    }

    public static void printMenuCategory(int number, String category) {
        System.out.println(number + ". " + category);
    }

    public static void printMenuFoods(List<String> menuFoods) {
        for(String menuFood: menuFoods)
            System.out.println(menuFood);
        System.out.println("...");
    }

    public static void printOrdersStart() {
        System.out.println("주문 내역은 아래와 같습니다.");
    }

    public static void printOrdersInfo(List<String> orders) {
        for(String order: orders) {
            System.out.println(order);
        }
    }

    public static void printTotalPriceSum(int totalPriceSum) {
        System.out.println();
        System.out.println("총 가격 : " + totalPriceSum + "원");
        System.out.println();
    }

    public static void printCouponCnt(int couponCnt) {
        System.out.println();
        System.out.println("현재 쿠폰 갯수는 " + couponCnt + "개 입니다.");
        System.out.println();
    }

    public static void printCouponUse() {
        System.out.println();
        System.out.println("사용이 완료되었습니다.");
        System.out.println();
    }

    public static void printOrderEnd() {
        System.out.println("주문 완료가 되었습니다.");
        System.out.println();
    }
}
