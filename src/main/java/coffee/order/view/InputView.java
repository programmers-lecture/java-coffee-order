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

    public static void inputYesOrNo(){
        Scanner sc = new Scanner(System.in);
        String answer = sc.nextLine();
    }

    public static void inputPhoneNumber() {
        Scanner sc = new Scanner(System.in);
        String phoneNumber = sc.nextLine();
    }

}
