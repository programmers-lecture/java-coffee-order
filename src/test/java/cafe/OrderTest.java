package cafe;

import menu.MenuCategory;
import menu.MenuItem;
import org.junit.jupiter.api.*;

import java.math.BigDecimal;

import static org.assertj.core.api.Assertions.assertThat;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class OrderTest {
    static MenuItem menuItem1;
    static MenuItem menuItem2;
    static MenuItem menuItem3;

    @BeforeAll
    static void init() {
        menuItem1 = new MenuItem(MenuCategory.COFFEE,
                1,
                "에스프레소",
                BigDecimal.valueOf(2000.0));
        menuItem2 = new MenuItem(MenuCategory.TEA,
                1,
                "녹차",
                BigDecimal.valueOf(2000.0));
        menuItem3 = new MenuItem(MenuCategory.DESSERT,
                1,
                "브라우니",
                BigDecimal.valueOf(2000.0));
    }

    @Test
    @DisplayName("주문 추가 테스트")
    void addOrder() {
        Order order = new Order();
        order.addOrder(menuItem1, 3);
        order.addOrder(menuItem2, 4);
        order.addOrder(menuItem3, 5);

        assertThat(order.getOrders().containsKey(menuItem1)).isEqualTo(true);
        assertThat(order.getOrders().containsKey(menuItem2)).isEqualTo(true);
        assertThat(order.getOrders().containsKey(menuItem3)).isEqualTo(true);

        assertThat(order.getOrders().get(menuItem1)).isEqualTo(3);
        assertThat(order.getOrders().get(menuItem2)).isEqualTo(4);
        assertThat(order.getOrders().get(menuItem3)).isEqualTo(5);
    }

    @Test
    @DisplayName("toString() 테스트")
    void testToString() {
        Order order = new Order();
        order.addOrder(menuItem1, 3);
        order.addOrder(menuItem2, 7);
        order.addOrder(menuItem3, 5);

        assertThat(order.toString()).isEqualTo(
                "1-1 에스프레소 3개 / 2-1 녹차 7개 / 3-1 브라우니 5개 -> 총 30000.0원");
    }
}