package io.output;

import coupon.Coupon;
import cafe.Order;
import java.math.BigDecimal;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import menu.MenuCategory;
import menu.MenuItem;

public class Output {
    private static final String HYPHEN = "-";

    public static void printMenuItems(Map<MenuCategory, List<MenuItem>> menuItems) {
        List<MenuCategory> menuCategories;
        menuCategories = menuItems.keySet().stream().collect(Collectors.toList());
        Collections.sort(menuCategories, menuCategoryComparator());
        for (MenuCategory menuCategory : menuCategories) {
            System.out.println(menuCategory.getCategoryNumber()
                    + ". "
                    + menuCategory.getCategoryName()
            );
            menuItems.get(menuCategory)
                    .forEach(menuItem -> System.out.println(" " + menuItem.toString()));

        }
    }

    public static void printUserChoiceRequestMessage() {
        System.out.println("사용자를 선택하세요\n"
                + "1. 손님 / 2. 바리스타\n"
                + "\n"
                + "#----------------------------------#"
        );
    }

    public static void printBaristaOptions() {
        System.out.println("사용할 메뉴를 선택하세요\n"
                + "1. 메뉴 등록\n"
                + "2. 수량 등록\n"
                + "3. 가격 변경\n"
                + "4. 주문 내역 확인\n"
                + "5. 쿠폰 내역 확인\n"
                + "\n"
                + "-----------------"
        );
    }

    public static void printRegisterMenuItemMessage() {
        System.out.println("번호와 이름, 가격을 입력해주세요.\n"
                + "ex) 1. 커피, 1-1. 에스프레소, 2000"
        );
    }

    public static void printSetStockMessage() {
        System.out.println("번호와 수량을 선택해주세요. (ex) 1-1, 10");
    }

    public static void printSuccessfullyRegisteredMessage() {
        System.out.println("\n입력이 완료되었습니다.\n"
                + "---------------");
    }

    public static void printSuccessfullySetStockMessage() {
        System.out.println("\n입력이 완료되었습니다.\n"
                + "---------------");
    }

    public static void printChangePriceMessage() {
        System.out.println("번호와 가격을 선택해주세요. (ex) 1-1, 2500");
    }

    public static void printSuccessfullyChangedPriceMessage(MenuCategory menuCategory,
            int menuNumber, BigDecimal price) {
        System.out.println();
        System.out.println(menuCategory.getCategoryNumber()
                + HYPHEN
                + menuNumber
                +"의 가격을 "
                + price
                +"원으로 "
                + "변경하셨습니다."
        );
    }

    public static void printOrderHistory(Map<Integer, Order> orderHistory, BigDecimal sales) {
        orderHistory.forEach((orderNumber, order) ->
                System.out.println(orderNumber + ". " + order.toString()));
        System.out.println("------------");
        System.out.println("현재까지 매출 : " + sales);
    }

    public static void printCouponHistory(Map<Coupon, Integer> couponHistory) {
        List<Coupon> coupons = couponHistory.keySet().stream().collect(Collectors.toList());
        int couponUseSequence = 1;
        for(Coupon coupon : coupons) {
            System.out.println(couponUseSequence
                    + ". "
                    + coupon.toString()
                    + " - "
                    + couponHistory.get(coupon)
                    + "개"
            );
            couponUseSequence++;
        }
    }

    private static Comparator<MenuCategory> menuCategoryComparator() {
        return (category1, category2) ->
                category1.getCategoryNumber() - category2.getCategoryNumber();
    }
}
