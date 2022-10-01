package coffee.order.domain;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class Coupon {
    private static final Map<String, Integer> couponMenus = new ConcurrentHashMap<>();
    public static final int COUPON_PER_MENU = 10;


    public static void addMenu(String phoneNumber, int count) {
        if (couponMenus.containsKey(phoneNumber)) {
            couponMenus.put(phoneNumber, couponMenus.get(phoneNumber) + count);
        } else if (!couponMenus.containsKey(phoneNumber)) {
            couponMenus.put(phoneNumber, count);
        }
    }

    public static int getAmount(String phoneNumber) {
        return couponMenus.get(phoneNumber);
    }

    public int getCouponCount(String phoneNumber) {
        return couponMenus.get(phoneNumber);
    }

    public boolean isUseCoupon(String phoneNumber) {
        return getCouponCount(phoneNumber) >= 10;
    }

    public void useCoupon(String phoneNumber) {
        couponMenus.put(phoneNumber, couponMenus.get(phoneNumber) - COUPON_PER_MENU);
    }
}
