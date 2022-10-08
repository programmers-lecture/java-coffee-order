package coffee.order.repository;

import coffee.order.view.model.PhoneNumber;

import java.util.HashMap;

public class CouponRepository {
    private final HashMap<PhoneNumber, Integer> couponDatabase;

    public CouponRepository() {
        couponDatabase = new HashMap<>();
    }
}
