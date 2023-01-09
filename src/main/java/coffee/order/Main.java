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



    }
}