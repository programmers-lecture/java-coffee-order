package io.output;

import domain.coupon.Coupon;
import domain.order.OrderList;
import io.input.information.ChangePriceInformation;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import domain.menu.MenuCategory;
import domain.menu.MenuItem;

public class Output {

    private static final String HYPHEN = "-";

    private Output() {
    }

    public static void printUserSelectionRequestMessage() {
        System.out.println("사용자를 선택하세요");
        System.out.println("1. 손님 / 2. 바리스타 / 0. 종료");
    }

    public static void printBaristaSelectionRequestMessage() {
        System.out.println("#----------------------------------#");
        System.out.println();
        System.out.println("사용할 메뉴를 선택하세요\n"
                + "1. 메뉴 등록\n"
                + "2. 수량 등록\n"
                + "3. 가격 변경\n"
                + "4. 주문 내역 확인\n"
                + "5. 쿠폰 내역 확인\n"
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

    public static void printSuccessfullyChangedPriceMessage(
            final ChangePriceInformation changePriceInformation) {
        System.out.println();
        System.out.println(changePriceInformation.getMenuCategory().getCategoryNumber()
                + HYPHEN
                + changePriceInformation.getMenuNumber()
                + "의 가격을 "
                + changePriceInformation.getPrice()
                + "원으로 "
                + "변경하셨습니다."
        );
    }

    public static void printOrderHistory(final Map<Integer, OrderList> orderHistory,
            final BigDecimal sales) {
        orderHistory.forEach((orderNumber, order) ->
                System.out.println(orderNumber + ". " + order.showOrderForOrderHistory()));
        System.out.println("------------");
        System.out.println("현재까지 매출 : " + sales);
    }

    public static void printCouponHistory(final Map<Coupon, Integer> couponHistory) {
        List<Coupon> coupons = new ArrayList<>(couponHistory.keySet());
        int couponUseSequence = 1;
        for (Coupon coupon : coupons) {
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

    public static void printMenuStock(final Map<MenuCategory, List<MenuItem>> menuItems) {
        List<MenuCategory> menuCategories = new ArrayList<>(menuItems.keySet());
        menuCategories.sort(menuCategoryComparator());
        for (MenuCategory menuCategory : menuCategories) {
            System.out.println(menuCategory.getCategoryNumber()
                    + ". "
                    + menuCategory.getCategoryName()
            );
            menuItems.get(menuCategory)
                    .forEach(menuItem -> System.out.println(" "
                            + menuItem.getMenuCategory().getCategoryNumber()
                            + "-"
                            + menuItem.getMenuNumber()
                            + " // "
                            + menuItem.getStock()
                            + "개"))
            ;
        }
    }

    public static void printMenuPrice(final Map<MenuCategory, List<MenuItem>> menuItems) {
        List<MenuCategory> menuCategories = new ArrayList<>(menuItems.keySet());
        menuCategories.sort(menuCategoryComparator());
        for (MenuCategory menuCategory : menuCategories) {
            System.out.println(menuCategory.getCategoryNumber()
                    + ". "
                    + menuCategory.getCategoryName()
            );
            menuItems.get(menuCategory)
                    .forEach(menuItem -> System.out.println(" "
                            + menuItem.getMenuCategory().getCategoryName()
                            + "-"
                            + menuItem.getMenuNumber()
                            + " // "
                            + menuItem.getPrice()
                            + "원"))
            ;
        }
    }

    private static Comparator<MenuCategory> menuCategoryComparator() {
        return (category1, category2) ->
                category1.getCategoryNumber() - category2.getCategoryNumber();
    }

    public static void printChoiceMenuRequestMessage() {
        System.out.println("#----------------------------------#");
        System.out.println();
        System.out.println("메뉴를 골라주세요 (번호, 갯수)");
    }

    public static void printMenu(final Map<MenuCategory, List<MenuItem>> menuItems) {
        List<MenuCategory> menuCategories = new ArrayList<>(menuItems.keySet());
        menuCategories.sort(menuCategoryComparator());
        for(MenuCategory menuCategory : menuCategories) {
            System.out.println(menuCategory.getCategoryNumber()
                    + ". "
                    + menuCategory.getCategoryName()
            );
            menuItems.get(menuCategory)
                    .forEach(menuItem -> System.out.println(" "
                            + menuItem.getMenuCategory().getCategoryNumber()
                            + "-"
                            + menuItem.getMenuNumber()
                            + " "
                            + menuItem.getMenuName())
                    );
        }
    }

    public static void printSuccessfullyOrderedMessage(OrderList orderList) {
        System.out.println();
        System.out.println("-----------------------");
        System.out.println();
        System.out.println("주문 내역은 아래와 같습니다.");
        System.out.println(orderList.showOrderForOrderList());
        System.out.println();
        System.out.println("총 가격 : " + orderList.getPrice() + "원");
        System.out.println();
    }

    public static void printAskAdditionalOrderMessage() {
        System.out.println("추가 주문 하시겠습니까? (예 : 1, 아니오 : 2)");
    }

    public static void printUseCouponSelectionRequestMessage() {
        System.out.println();
        System.out.println("-----------------------");
        System.out.println();
        System.out.println("쿠폰을 사용하시겠습니까?");
        System.out.println("1. 네 / 2. 아니요");
    }

    public static void printPhoneNumberRequestMessage() {
        System.out.println();
        System.out.println("-----------------------");
        System.out.println("전화번호를 입력해주세요. (형식 : 000-0000-0000)");
    }

    public static void printSuccessfullyEarnedCoupon(int couponCount) {
        System.out.println();
        System.out.println("현재 쿠폰 갯수는 " + couponCount + "개 입니다.");
    }

    public static void printChoiceOrderForApplyCouponMessage() {
        System.out.println();
        System.out.println("-----------------------");
        System.out.println("사용할 메뉴를 골라주세요");
    }

    public static void printEarnCouponSelectionRequestMessage() {
        System.out.println("쿠폰을 적립하시겠습니까?");
        System.out.println("1. 네 / 2. 아니요");
    }

    public static void printOrderForUseCoupon(String order) {
        System.out.println();
        System.out.println(order);
    }
}
