package coffee.order;

import coffee.order.controller.Cafe;
import coffee.order.models.Customer;
import coffee.order.controller.Kiosk;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        Cafe cafe = new Cafe();
        Kiosk kiosk = new Kiosk();
        boolean isOrderEnd = false;
        while(!isOrderEnd) {
            Customer customer = new Customer();
            kiosk.showMenus(cafe.getMenus());
            List<String[]> menuOrders = kiosk.selectMenus();
            cafe.createOrders(menuOrders, customer);
            kiosk.showOrders(cafe.getOrders(), customer);
            kiosk.earnCoupons(customer);
            int couponsCnt = cafe.earnCoupons(customer);
            kiosk.showCoupons(couponsCnt);
            if(kiosk.isCustomerUseCoupons(couponsCnt)) {
                String selectMenu = kiosk.selectCouponsUseMenu(cafe.getOrders(), customer);
                cafe.useCouponForOrder(customer, selectMenu);
                kiosk.showCouponsUseMenu(cafe.getOrders(), customer);
            }
            isOrderEnd = kiosk.isKioskEnd();
        }
    }
}