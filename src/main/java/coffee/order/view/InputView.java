package coffee.order.view;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class InputView {
    public InputView(){}

    public static List<String> inputOrder() {
        Scanner sc = new Scanner(System.in);
        List<String> orders = new ArrayList<>();
        String order;
        while(sc.hasNextLine() && !(order = sc.nextLine()).isEmpty()){
            orders.add(order);
        }
        return orders;
    }

    // 이 두개를 합쳐 : 아닌 적립 안한다 하는 경우 빈 문자열 반환
    public static int inputYesOrNo(){
        Scanner sc = new Scanner(System.in);
        return sc.nextInt();
    }

    public static String inputPhoneNumber() {
        Scanner sc = new Scanner(System.in);
        return sc.nextLine();
    }

    public static String inputCouponMenuSerialNumber(){
        Scanner sc = new Scanner(System.in);
        return sc.nextLine();
    }



}
