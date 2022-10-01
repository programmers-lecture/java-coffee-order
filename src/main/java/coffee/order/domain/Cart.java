package coffee.order.domain;

import java.util.Map;
import java.util.Map.Entry;
import java.util.concurrent.ConcurrentHashMap;

public class Cart {

    public static final int REDUCE_MENU_AMOUNT = 1;
    public static final int COUPON_MENU_AMOUNT = 1;
    private final Coupon coupon = new Coupon();
    private final Map<Menu, Integer> cart = new ConcurrentHashMap<>();
    private final Map<Menu, Integer> couponMenu = new ConcurrentHashMap<>();
    private int totalPrice;

    public void addMenu(Menu menu, int count) {
        if (cart.containsKey(menu)) {
            cart.put(menu, cart.get(menu) + count);
        } else if (!cart.containsKey(menu)) {
            cart.put(menu, count);
        }
    }

    public String getCartInfo() {
        return couponMenuInfo() + cartInfo() + "총 가격: " + getTotalPrice() + "원";
    }

    private String cartInfo() {
        StringBuilder stringBuilder = new StringBuilder();
        for (Entry<Menu, Integer> entry : cart.entrySet()) {
            stringBuilder.append(entry.getKey().getName() + " ")
                    .append(entry.getValue() + "개 ")
                    .append(entry.getKey().getPrice() * entry.getValue())
                    .append("원\n");
        }
        return String.valueOf(stringBuilder.append("\n"));
    }

    private int getTotalPrice() {
        for (Entry<Menu, Integer> entry : cart.entrySet()) {
            totalPrice += entry.getKey().getPrice() * entry.getValue();
        }
        return totalPrice;
    }

    public String getMenuList() {
        StringBuilder stringBuilder = new StringBuilder();
        for (Entry<Menu, Integer> entry : cart.entrySet()) {
            stringBuilder.append(entry.getKey().getFoodCode())
                    .append(entry.getKey().getName() + "\n");
        }
        return String.valueOf(stringBuilder.append("\n"));
    }

    private String couponMenuInfo() {
        StringBuilder stringBuilder = new StringBuilder();
        for (Entry<Menu, Integer> entry : couponMenu.entrySet()) {
            stringBuilder.append(entry.getKey().getName())
                    .append(entry.getValue() + "개 ")
                    .append("쿠폰사용");
        }
        return String.valueOf(stringBuilder.append("\n"));
    }

    public int getTotalAmount() {
        return cart.values().stream().mapToInt(Integer::valueOf).sum();
    }

    public boolean isUseCoupon(String phoneNumber) {
        return coupon.isUseCoupon(phoneNumber);
    }

    public void useCoupon(Menu menu, String phoneNumber) {
        applyCoupon(menu);
        coupon.useCoupon(phoneNumber);
        couponMenu.put(menu, COUPON_MENU_AMOUNT);
    }


    private void applyCoupon(Menu menu) {
        cart.put(menu, cart.get(menu) - REDUCE_MENU_AMOUNT);
    }
}
