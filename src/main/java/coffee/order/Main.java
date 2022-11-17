package coffee.order;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import coffee.order.Menu.Coffee;
import coffee.order.Menu.Dessert;
import coffee.order.Menu.Tea;
import coffee.order.Coupon;

import static java.lang.String.valueOf;

public class Main {
    public static void main(String[] args) {
        // 1. 메뉴판을 보여줍니다. (커피, 차, 디저트)
        showMenus();

        //2. 주문을 받습니다.
        HashMap<String, String >orderedMenu = getChoice();

        //3. 주문을 확인합니다.
        System.out.println("주문 내역은 아래와 같습니다.");
        printOrder(orderedMenu);

    };

    public static ArrayList<Coffee> getCoffees() {
        Coffee espresso  = new Coffee("에스프레소", 2000);
        Coffee americano = new Coffee("아메리카노", 3000);
        Coffee latte     = new Coffee("라떼", 0);
        Coffee coldbrew  = new Coffee("콜드브루", 5000);

        ArrayList<Coffee> coffees = new ArrayList<>(List.of(espresso, americano, latte, coldbrew));
        System.out.println("coffee~" + coffees);
        return coffees;
    }

    public static ArrayList<Tea> getTeas() {
        Tea greenTea = new Tea("녹차", 2000);
        Tea blackTea = new Tea("홍차", 3000);
        Tea camomile = new Tea("캐모마일", 0);
        Tea milkTea  = new Tea("밀크티", 5000);

        ArrayList<Tea> teas = new ArrayList<>(List.of(greenTea, blackTea, camomile, milkTea));
        return teas;
    }

    public static ArrayList<Dessert> getDesserts() {
        Dessert cake     = new Dessert("케이크", 5000);
        Dessert icecream = new Dessert("아이스크림", 4000);
        Dessert cookie   = new Dessert("쿠키", 3000);
        Dessert pudding  = new Dessert("푸딩", 0);

        ArrayList<Dessert> desserts = new ArrayList<>(List.of(cake, icecream, cookie, pudding));
        return desserts;
    }

    public static void showMenus() {
        ArrayList<Coffee> coffees   = getCoffees();
        ArrayList<Tea> teas         = getTeas();
        ArrayList<Dessert> desserts = getDesserts();

        System.out.println("메뉴를 선택하세요.(번호, 수량)");

        System.out.println("1. 커피");
        for(int i = 0; i < coffees.size(); i++) {
            int subMenuCode = (i + 1);
            System.out.println("1-" + subMenuCode + " " + coffees.get(i).name + " : " + coffees.get(i).price);
        }

        System.out.println("2. 차");
        for(int i=0; i<teas.size(); i++) {
            int subMenuCode = (i + 1);
            System.out.println("2-" + subMenuCode + " " + teas.get(i).name + " : " + teas.get(i).price);
        }

        System.out.println("3. 디저트");
        for(int i=0; i<desserts.size(); i++) {
            int subMenuCode = (i + 1);
            System.out.println("3-" + subMenuCode + " " + desserts.get(i).name + " : " + desserts.get(i).price);
        }
    };

    public static HashMap<String, String> getChoice() throws ArrayIndexOutOfBoundsException {

        Scanner sc = new Scanner(System.in);
        HashMap<String,String> order = new HashMap<>();

        try {
            while(true) {
                String choice = sc.nextLine();
                if(choice.isEmpty()) {
                    System.out.println("메뉴 선택이 완료되었습니다.");
                    break;
                }
                String[] choiceArr = choice.split(",");

                String menuCode = choiceArr[0];
                String menuQty  = choiceArr[1];

                order.put(menuCode, menuQty);
            }
        } catch (ArrayIndexOutOfBoundsException e) {
            //TODO: Exception 발생시 주문 재시작을 할 수 있는 방법 찾기
            System.out.println("잘못된 입력입니다. 수량을 확인하세요.");
        }

        return order;
    };

    public static void printOrder(HashMap<String, String> order) {
        ArrayList<Coffee> coffees   = getCoffees();
        ArrayList<Tea> teas         = getTeas();
        ArrayList<Dessert> desserts = getDesserts();

        int orderTotPrice = 0; //주문 총액
        int orderTotQty   = 0; //주문 총수량

        for(String key : order.keySet()) {
            String menuCode = key;
            String menuQty  = order.get(key);

            String menuName = "";
            int menuPrice     = 0;
            int menuTotPrice  = 0; //메뉴별 금액 총합

            if(menuCode.startsWith("1")) {
                int menuIndex = Integer.parseInt(menuCode.substring(2)) - 1;
                menuName = coffees.get(menuIndex).name;
                menuPrice = coffees.get(menuIndex).price;
            }

            if(menuCode.startsWith("2")) {
                int menuIndex = Integer.parseInt(menuCode.substring(2)) - 1;
                menuName = teas.get(menuIndex).name;
                menuPrice = teas.get(menuIndex).price;
            }

            if(menuCode.startsWith("3")) {
                int menuIndex = Integer.parseInt(menuCode.substring(2)) - 1;
                menuName = desserts.get(menuIndex).name;
                menuPrice = desserts.get(menuIndex).price;
            }

            menuTotPrice = menuPrice * Integer.parseInt(menuQty);

            orderTotPrice += menuTotPrice;
            orderTotQty   += Integer.parseInt(menuQty);

            System.out.println(menuName + " " + menuQty + "개 " + menuTotPrice + "원");
        }

        System.out.println("주문 총액 : " + orderTotPrice + "원");
        System.out.println("쿠폰을 적립하시겠습니까?(1. 예, 2. 아니오)");

        Scanner sc = new Scanner(System.in);

        if(sc.nextInt() == 1) {
            System.out.println("핸드폰 번호를 입력하세요.");
            while(true) {
                String phoneNumber = sc.next();
                if(isValidPhoneNumber(phoneNumber)) {
                    if(Coupon.getStampCount() < 10) {
                        System.out.println("쿠폰 발행을 위한 스탬프 수량이 부족합니다. 스탬프 적립만 진행합니다.");
                        Coupon.saveStamps(orderTotQty);
                    } else {
                        System.out.println("사용 가능한 쿠폰은 " + Coupon.getCouponCount() + "장 입니다. 사용하시겠습니까?");
                        System.out.println("1. 사용, 2. 미사용");

                        if(sc.nextInt() == 1) {
                               //TODO: 쿠폰 사용 로직 추가
                        } else {
                            Coupon.saveStamps(orderTotQty);
                        }
                    }
                    break;
                }
            }
        }
    };


    public static boolean isValidPhoneNumber(String number) {
        Pattern pattern = Pattern.compile("\\d{3}-\\d{4}-\\d{4}");
        Matcher matcher = pattern.matcher(number);
        if (matcher.matches()) {
            System.out.println("Valid phone number: " + number);
            return true;
        } else {
            System.out.println("핸드폰 번호 형식이 올바르지 않습니다.000-0000-0000 형식으로 입력하세요.");
            return false;
        }
    }
}