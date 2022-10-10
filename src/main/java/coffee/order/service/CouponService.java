package coffee.order.service;

import coffee.order.repository.CouponRepository;
import coffee.order.view.model.PhoneNumber;

public class CouponService {
    private static final int COUPON_APPLICATION_CRITERIA = 10;

    private final CouponRepository couponRepository;

    public CouponService() {
        couponRepository = new CouponRepository();
    }

    public Integer getCouponQuantity(PhoneNumber phoneNumber) {
        if (!couponRepository.existsCustomer(phoneNumber)) {
            couponRepository.addNewCustomer(phoneNumber);
        }

        return couponRepository.findCouponQuantity(phoneNumber);
    }

    public boolean isCouponApplicable(Integer couponQuantity) {
        return couponQuantity > COUPON_APPLICATION_CRITERIA;
    }
}
