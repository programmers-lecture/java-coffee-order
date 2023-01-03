import coffee.order.domain.coupon.Customer;
import coffee.order.domain.meals.Menu;
import coffee.order.domain.meals.Tea;
import org.junit.jupiter.api.Test;

public class MenuTest {

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
}
