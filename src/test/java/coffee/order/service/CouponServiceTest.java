package coffee.order.service;

import coffee.order.view.model.PhoneNumber;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

class CouponServiceTest {
    private final CouponService couponService = new CouponService();

    @Test
    void should_couponQuantityIsZero_for_newCustomer() {
        // given
        PhoneNumber phoneNumber = new PhoneNumber("000-0000-0001");

        // when
        Integer couponQuantity = couponService.getCouponQuantity(phoneNumber);

        // then
        assertThat(couponQuantity).isEqualTo(1);
    }
}