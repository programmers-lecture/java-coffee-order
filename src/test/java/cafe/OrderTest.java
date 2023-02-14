package cafe;

import static org.assertj.core.api.Assertions.assertThat;

import domain.menu.MenuCategory;
import domain.menu.MenuItem;
import domain.order.Order;
import domain.order.OrderList;
import org.junit.jupiter.api.*;

import java.math.BigDecimal;

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
        OrderList orderList = new OrderList();
        Order order1 = new Order(menuItem1, 3);
        Order order2 = new Order(menuItem2, 4);
        Order order3 = new Order(menuItem3, 5);
        orderList.addOrder(order1);
        orderList.addOrder(order2);
        orderList.addOrder(order3);

        assertThat(orderList.getOrders().contains(order1)).isEqualTo(true);
        assertThat(orderList.getOrders().contains(order2)).isEqualTo(true);
        assertThat(orderList.getOrders().contains(order3)).isEqualTo(true);

        assertThat(orderList.getOrders().get(0).getCount()).isEqualTo(3);
        assertThat(orderList.getOrders().get(1).getCount()).isEqualTo(4);
        assertThat(orderList.getOrders().get(2).getCount()).isEqualTo(5);
    }
}