package coffee.order.service;

import coffee.order.repository.CouponRepository;
import coffee.order.view.model.PhoneNumber;

public class CouponService {
    private final CouponRepository couponRepository;

    public CouponService() {
        couponRepository = new CouponRepository();
    }

    public void getCouponQuantity(PhoneNumber phoneNumber) {

    }
}
