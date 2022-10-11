package coffee.order.repository;

import coffee.order.model.Order;
import coffee.order.model.Transaction;
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

    public void addCoupon(PhoneNumber phoneNumber, Transaction transaction) {
        if (!transaction.isCouponApplied()) {
            Integer lastCouponQuantity = findCouponQuantity(phoneNumber);

            Integer additionalCouponQuantity = transaction.getOrders().stream()
                    .map(Order::getOrderQuantity)
                    .reduce(0, Integer::sum);

            updateCouponQuantity(phoneNumber, lastCouponQuantity + additionalCouponQuantity);
        }
    }

    public boolean customerExists(PhoneNumber phoneNumber) {
        return couponDatabase.keySet().stream()
                .anyMatch(key -> key.equals(phoneNumber.getPhoneNumber()));
    }

    public Integer findCouponQuantity(PhoneNumber phoneNumber) {
        return couponDatabase.get(phoneNumber.getPhoneNumber());
    }

    public void applyCoupon(PhoneNumber phoneNumber, int couponApplicationCriteria) {
        Integer lastCouponQuantity = findCouponQuantity(phoneNumber);
        updateCouponQuantity(phoneNumber, lastCouponQuantity - couponApplicationCriteria);
    }

    private void updateCouponQuantity(PhoneNumber phoneNumber, Integer couponQuantity) {
        couponDatabase.put(phoneNumber.getPhoneNumber(), couponQuantity);
    }
}
