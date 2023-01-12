package coffee.order;

import coffee.order.controller.Cafe;
import coffee.order.controller.Counter;
import coffee.order.domain.meals.Category;
import coffee.order.domain.meals.Coffee;
import coffee.order.domain.meals.Menu;
import coffee.order.domain.order.Order;
import coffee.order.domain.order.Orders;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        Cafe cafe = new Cafe();
        Counter counter = new Counter();
        //메뉴 전체 조회
        counter.showMenu(cafe.getMenus());
        // 주문서 생성
        cafe.createOrderList(counter.takeOrder());
        counter.showOrder(cafe.getOrders());
        //쿠폰적립
        String phoneNumber = counter.askEarnCoupon();
        cafe.earnCoupon(phoneNumber);
        //쿠폰 보여주기
        int userCouponCnt = cafe.getCoupon(phoneNumber);
        counter.showCoupon(userCouponCnt);
        //쿠폰을 사용 할 수 있는 지
//        if(cafe.canUseCoupon(phoneNumber)){
//            //쿠폰을 사용할 의향이 있는 지
//            if(counter.askUseCoupon()==1){
//                //쿠폰 사용
//                counter.showOrdersToCouponUse(cafe.getOrders());
////                cafe.useCoupon(phoneNumber,counter.useCoupon()){
//
//                }
//
//            }
//            else{//종료
//                counter.endOrder();
//            }
//
//        }
        //종료
        counter.endOrder();



    }
}