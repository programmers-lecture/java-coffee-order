package coffee.order.view;

import coffee.order.controller.Cafe;
import coffee.order.domain.meals.Coffee;
import coffee.order.domain.order.Orders;

import java.awt.*;
import java.util.List;
import java.util.Objects;
import java.util.stream.Stream;

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

    public static void printAskEarnCoupon(){ System.out.println("쿠폰을 적립 하시겠습니까?"); }


}
