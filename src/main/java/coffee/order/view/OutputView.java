package coffee.order.view;
import java.util.List;


public class OutputView {

    public static void printSelectMenu(){System.out.println("메뉴를 골라주세요 (번호, 갯수)");}

    public static void printMenuCategory(int categoryNumber,String category ) {
        System.out.println(categoryNumber + ". " + category); }

    public static void printMenuType(List<String> menuType){
        menuType.stream().forEach(System.out::println);    }

    public static void printOrder(List<String> orderList){
        System.out.println("주문 내역은 다음과 같습니다.");
        orderList.stream().forEach(System.out::println);
    }

    public static void printOrderTotalPrice(int totalPrice){
        System.out.println("총 가격 : "+totalPrice+"원");
    }

    public static void printAskEarnCoupon(){
        System.out.println("쿠폰을 적립하시겠습니까?");
        System.out.println("1. 네 2. 아니오");}

    public static void printAskPhoneNumber(){
        System.out.println("전화번호를 입력해주세요. (형식 : 000-0000-0000)");
    }

    public static void printCouponCount(int userCouponCnt){
        System.out.println("현재 쿠폰 개수는 " + userCouponCnt + "개 입니다");
    }

    public static void printAskUseCoupon() {
        System.out.println("쿠폰을 사용하시겠습니까?");
        System.out.println("1. 네 2. 아니오");
    }

    public static  void printSelectUseCouponMenu(){
        System.out.println("사용할 메뉴를 골라주세요.");
    }

    public static void printEndOrder(){
        System.out.println("주문이 완료되었습니다.");
    }

}
