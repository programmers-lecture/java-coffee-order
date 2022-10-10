package coffee.order.dto.customer;

import coffee.order.domain.customer.wallet.Coupon;

public class WalletDto {

    private final CouponDto couponDto;

    public WalletDto(CouponDto couponDto) {
        this.couponDto = couponDto;
    }
}
