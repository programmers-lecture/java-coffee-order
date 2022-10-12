package coffee.order.views;

import coffee.order.common.Constants;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import static coffee.order.common.Constants.*;

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
        System.out.println(EARN_COUPON_QUESTION);
        System.out.println(YES_OR_NO_ANSWER);
        System.out.println();
        Scanner scanner = new Scanner(System.in);
        String selection = scanner.next();
        System.out.println();
        if(selection.equals(YES)) {
            System.out.println(INPUT_PHONE_NUMBER_REQUEST);
            return scanner.next();
        }
        return "";
    }

    public static boolean inputCouponUseOrNot() {
        System.out.println(USE_COUPON_QUESTION);
        System.out.println(YES_OR_NO_ANSWER);
        System.out.println();
        Scanner scanner = new Scanner(System.in);
        return scanner.next().equals(YES);
    }

    public static String inputOrderFoodForUseCoupon(List<String> ordersInfo) {
        System.out.println(SELECT_USE_COUPON_MENU_REQUEST);
        for(String orderInfo: ordersInfo) {
            System.out.println(orderInfo);
        }
        System.out.println();
        Scanner scanner = new Scanner(System.in);
        return scanner.next();
    }

    public static boolean inputOrderEnd() {
        System.out.println();
        System.out.println(ORDER_AGAIN_QUESTION);
        System.out.println(YES_OR_NO_ANSWER);
        Scanner scanner = new Scanner(System.in);
        return scanner.next().equals(NO);
    }
}
