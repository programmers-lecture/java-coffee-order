package coffee.order.service;

import coffee.order.repository.CouponRepository;
import coffee.order.view.model.PhoneNumber;

public class CouponService {
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
}
