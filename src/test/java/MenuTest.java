import coffee.order.controller.Cafe;
import coffee.order.controller.Counter;
import coffee.order.domain.meals.*;
import coffee.order.domain.order.Order;
import coffee.order.domain.order.Orders;
import coffee.order.view.InputView;
import coffee.order.view.OutputView;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

public class MenuTest {
    private OutputView outputView;

    @Test
    public void 시리얼넘버_메뉴검색_테스트(){
        String s = "3-2";
        Tea tea =new Tea();
        Menu res = tea.findBySerialNumber(s);
        System.out.println(res.toString());
    }

    @Test
    public void 휴대폰번호_정규식_테스트(){
        String n1 = "010-1234-1234";
        String n2 = "01";
//        Customer customer = new Customer(n1);
//        Customer customer2 = new Customer(n2);
//        System.out.println(customer.regexPhoneNUmber(n1));
//        System.out.println(customer2.regexPhoneNUmber(n2));
    }
    @Test
    public void 전체메뉴조회(){
        Cafe cafe = new Cafe();
        Counter counter = new Counter();
        counter.showMenu(cafe.getMenus());

    }

    @Test
    public void 주문서생성(){
        Cafe cafe = new Cafe();
        Counter counter = new Counter();
        counter.takeOrder();
        counter.showOrder(cafe.getOrders());

    }
}
