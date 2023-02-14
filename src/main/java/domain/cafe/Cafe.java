package domain.cafe;

import domain.order.OrderList;
import domain.coupon.Coupon;
import domain.menu.MenuItem;
import io.input.information.ChangePriceInformation;
import io.input.information.SetStockInformation;
import io.output.Output;
import java.math.BigDecimal;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import domain.menu.Menu;

public class Cafe {
    private static final int FIRST_ORDER = 1;
    private static final int ONE = 1;
    private static final int COUPON_COUNT_FOR_ONE_MENU = 1;

    private BigDecimal sales;
    private final Map<Integer, OrderList> orderHistory;
    private final Map<Coupon, Integer> couponHistory;
    private final Map<Coupon, Integer> coupons;
    private final Menu menu;

    public Cafe() {
        this.menu = new Menu();
        this.sales = BigDecimal.ZERO;
        this.orderHistory = new HashMap<>();
        this.couponHistory = new HashMap<>();
        this.coupons = new HashMap<>();
    }

    public void checkOrderHistory() {
        Output.printOrderHistory(Collections.unmodifiableMap(orderHistory), sales);
    }

    public void checkCouponHistory() {
        Output.printCouponHistory(Collections.unmodifiableMap(couponHistory));
    }

    public void addOrderHistory(OrderList orderList) {
        if(orderHistory.isEmpty()) {
            orderHistory.put(FIRST_ORDER, orderList);
            addSales(orderList);
            return;
        }
        int orderNumber = orderHistory.size() + ONE;
        orderHistory.put(orderNumber, orderList);
        addSales(orderList);
    }

    public void addCouponHistory(Coupon coupon) {
        couponHistory.put(coupon, couponHistory.getOrDefault(coupon, 0) + COUPON_COUNT_FOR_ONE_MENU);
    }

    public void earnCoupon(Coupon coupon) {
        coupons.put(coupon, coupons.getOrDefault(coupon, 0) + 1);
    }

    private void addSales(OrderList orderList) {
        sales = sales.add(orderList.getPrice());
    }

    public boolean canUseCoupon(Coupon coupon) {
        return coupons.get(coupon) >= COUPON_COUNT_FOR_ONE_MENU;
    }

    public int getCouponCount(Coupon coupon) {
        return coupons.get(coupon);
    }

    public Menu getMenu() {
        return menu;
    }

    public void initMenu() {
        this.menu.init();
    }

    public void useCoupon(Coupon coupon) {
        coupons.put(coupon, coupons.get(coupon) - COUPON_COUNT_FOR_ONE_MENU);
    }

    public void showMenu() {
        menu.showMenu();
    }

    public void showMenuStock() {
        menu.showStock();
    }

    public void setMenuStock(SetStockInformation setStockInformation) {
        menu.setStock(setStockInformation);
    }

    public void showMenuPrice() {
        menu.showPrice();
    }

    public void changeMenuPrice(ChangePriceInformation changePriceInformation) {
        menu.changePrice(changePriceInformation);
    }

    public void registerMenuItem(MenuItem menuItem) {
        menu.registerMenuItem(menuItem);
    }

    public void reduceMenuStock(OrderList orderList) {
        menu.reduceStock(orderList);
    }
}
