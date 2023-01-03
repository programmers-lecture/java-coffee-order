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

}
