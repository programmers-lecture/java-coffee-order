package coffee.order.views;

import coffee.order.enums.Coffee;
import coffee.order.enums.Dessert;
import coffee.order.enums.Tea;
import coffee.order.models.Order;

import java.util.List;

public class OutputView {
    private OutputView() {}

    public static void printMenu() {
        System.out.println("메뉴를 골라주세요 (번호, 갯수)");
        printCoffeeMenu();
        System.out.println("...");
        printTeaMenu();
        System.out.println("...");
        printDessertMenu();
        System.out.println("...");
        System.out.println();
    }

    private static void printCoffeeMenu() {
        System.out.println("1. 커피");
        for(Coffee coffee: Coffee.values()) {
            System.out.println(coffee.getCoffeeMenu());
        }
    }

    private static void printTeaMenu() {
        System.out.println("2. 티");
        for(Tea tea: Tea.values()) {
            System.out.println(tea.getTeaMenu());
        }
    }

    private static void printDessertMenu() {
        System.out.println("3. 디저트");
        for(Dessert dessert: Dessert.values()) {
            System.out.println(dessert.getDessertMenu());
        }
    }

    public static void printOrders(List<Order> orders) {
        System.out.println("주문 내역은 아래와 같습니다.");
        int sum = 0;
        for(Order order: orders) {
            sum += order.getMenuPrice();
            System.out.print(order.getMenuName() + " " + order.getCount() + "개 ");
            System.out.print(order.getIsCouponUsed() ? "쿠폰사용" : order.getMenuPrice() + "원");
            System.out.println();
        }
        System.out.println();
        System.out.println("총 가격 : " + sum + "원");
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
