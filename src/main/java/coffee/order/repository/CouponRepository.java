package coffee.order.repository;

import coffee.order.view.model.PhoneNumber;

import java.util.HashMap;
import java.util.NoSuchElementException;
import java.util.function.Predicate;

public class CouponRepository {
    private static final int INITIAL_COUPON_QUANTITY = 0;

    private final HashMap<PhoneNumber, Integer> couponDatabase;

    public CouponRepository() {
        couponDatabase = new HashMap<>();
    }
    
    public boolean existsCustomer(PhoneNumber phoneNumber) {
        return couponDatabase.keySet().stream()
                .anyMatch(findMatchPhoneNumber(phoneNumber));
    }

    public void addNewCustomer(PhoneNumber phoneNumber) {
        couponDatabase.put(phoneNumber, INITIAL_COUPON_QUANTITY);
    }

    public Integer findCouponQuantity(PhoneNumber phoneNumber) {
        return couponDatabase.keySet().stream()
                .filter(findMatchPhoneNumber(phoneNumber))
                .findFirst()
                .map(couponDatabase::get)
                .orElseThrow(NoSuchElementException::new);
    }

    private Predicate<PhoneNumber> findMatchPhoneNumber(PhoneNumber phoneNumber) {
        return key -> key.getPhoneNumber().equals(phoneNumber.getPhoneNumber());
    }
}
