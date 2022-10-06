package coffee.order.views;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class InputView {
    private InputView() {}

    public static List<String> inputOrder() {
        Scanner scanner = new Scanner(System.in);
        List<String> orders = new ArrayList<>();
        String order;
        while(scanner.hasNextLine() && !(order = scanner.nextLine()).isEmpty()) {
            orders.add(order);
        }
        return orders;
    }

    public static String inputPhoneNumberForEarnCoupon() {
        System.out.println("쿠폰을 적립하시겠습니까?");
        System.out.println("1. 네 / 2. 아니요");
        System.out.println();
        Scanner scanner = new Scanner(System.in);
        String selection = scanner.next();
        System.out.println();
        if(selection.equals("1")) {
            System.out.println("전화번호를 입력해주세요. (형식 : 000-0000-0000)");
            return scanner.next();
        }
        return "";
    }

    public static boolean inputCouponUseOrNot() {
        System.out.println("쿠폰을 사용하시겠습니까?");
        System.out.println("1. 네 / 2. 아니요");
        System.out.println();
        Scanner scanner = new Scanner(System.in);
        return scanner.next().equals("1");
    }

    public static String inputOrderFoodForUseCoupon(List<String> ordersInfo) {
        System.out.println("사용할 메뉴를 골라주세요.");
        for(String orderInfo: ordersInfo) {
            System.out.println(orderInfo);
        }
        System.out.println();
        Scanner scanner = new Scanner(System.in);
        return scanner.next();
    }

    public static boolean inputOrderEnd() {
        System.out.println();
        System.out.println("주문을 새로 하시겠습니까?");
        System.out.println("1. 네 / 2. 아니요");
        Scanner scanner = new Scanner(System.in);
        return scanner.next().equals("2");
    }
}
