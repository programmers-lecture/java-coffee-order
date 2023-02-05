package cafe;

import coupon.Coupon;
import java.math.BigDecimal;
import menu.MenuCategory;
import menu.MenuItem;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class CafeTest {
    @Test
    @DisplayName("주문 내역 확인 테스트")
    void checkOrderHistory() {
        MenuItem menuItem1 = new MenuItem(MenuCategory.COFFEE,
                1,
                "에스프레소",
                BigDecimal.valueOf(1000.0));
        MenuItem menuItem2 = new MenuItem(MenuCategory.TEA,
                1,
                "녹차",
                BigDecimal.valueOf(2000.0));
        MenuItem menuItem3 = new MenuItem(MenuCategory.DESSERT,
                1,
                "브라우니",
                BigDecimal.valueOf(3000.0));

        Cafe cafe = new Cafe();

        Order order1 = new Order();
        order1.addOrder(menuItem1, 1);
        order1.addOrder(menuItem2, 2);
        order1.addOrder(menuItem3, 3);
        cafe.addOrderHistory(order1);

        Order order2 = new Order();
        order2.addOrder(menuItem1, 3);
        order2.addOrder(menuItem2, 4);
        order2.addOrder(menuItem3, 5);
        cafe.addOrderHistory(order2);

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