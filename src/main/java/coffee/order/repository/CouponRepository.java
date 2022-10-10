package coffee.order.repository;

import coffee.order.view.model.PhoneNumber;

import java.util.HashMap;

public class CouponRepository {
    private static final int INITIAL_COUPON_QUANTITY = 0;

    private final HashMap<String, Integer> couponDatabase;

    public CouponRepository() {
        couponDatabase = new HashMap<>();
    }

    public void addNewCustomer(PhoneNumber phoneNumber) {
        updateCouponQuantity(phoneNumber, INITIAL_COUPON_QUANTITY);
    }

    public void addCoupon(PhoneNumber phoneNumber, int orderQuantity) {
        Integer lastCouponQuantity = findCouponQuantity(phoneNumber);
        updateCouponQuantity(phoneNumber, lastCouponQuantity + orderQuantity);
    }

    public boolean customerExists(PhoneNumber phoneNumber) {
        return couponDatabase.keySet().stream()
                .anyMatch(key -> key.equals(phoneNumber.getPhoneNumber()));
    }

    public Integer findCouponQuantity(PhoneNumber phoneNumber) {
        return couponDatabase.get(phoneNumber.getPhoneNumber());
    }

    private void updateCouponQuantity(PhoneNumber phoneNumber, Integer couponQuantity) {
        couponDatabase.put(phoneNumber.getPhoneNumber(), couponQuantity);
        System.out.println("현재 쿠폰 개수 = " + couponDatabase.get(phoneNumber.getPhoneNumber()));
    }
}
