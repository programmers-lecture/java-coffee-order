package cafe;

import domain.cafe.Cafe;
import domain.order.Order;
import domain.order.OrderList;
import domain.coupon.Coupon;
import java.math.BigDecimal;
import domain.menu.MenuCategory;
import domain.menu.MenuItem;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class CafeTest {
    @Test
    @DisplayName("주문 내역 확인 테스트")
    void checkOrderHistory() {
        MenuItem menuItem1 = new MenuItem(MenuCategory.COFFEE,
                1,
                "에스프레소",
                BigDecimal.valueOf(1000));
        MenuItem menuItem2 = new MenuItem(MenuCategory.TEA,
                1,
                "녹차",
                BigDecimal.valueOf(2000));
        MenuItem menuItem3 = new MenuItem(MenuCategory.DESSERT,
                1,
                "브라우니",
                BigDecimal.valueOf(3000));

        Cafe cafe = new Cafe();

        OrderList orderList1 = new OrderList();
        orderList1.addOrder(new Order(menuItem1, 1));
        orderList1.addOrder(new Order(menuItem2, 2));
        orderList1.addOrder(new Order(menuItem3, 3));
        cafe.addOrderHistory(orderList1);

        OrderList orderList2 = new OrderList();
        orderList2.addOrder(new Order(menuItem1, 3));
        orderList2.addOrder(new Order(menuItem2, 4));
        orderList2.addOrder(new Order(menuItem3, 5));
        cafe.addOrderHistory(orderList2);

        cafe.checkOrderHistory();
    }

    @Test
    @DisplayName("쿠폰 사용 내역 확인 테스트")
    void checkCouponHistory() {
        Cafe cafe = new Cafe();
        cafe.addCouponHistory(new Coupon("010-1111-1111"));
        cafe.addCouponHistory(new Coupon("010-1111-1111"));
        cafe.addCouponHistory(new Coupon("010-1111-1111"));
        cafe.addCouponHistory(new Coupon("010-2222-2222"));

        cafe.checkCouponHistory();
    }
}