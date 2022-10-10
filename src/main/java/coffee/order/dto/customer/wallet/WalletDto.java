package coffee.order.dto.customer.wallet;

public class WalletDto {

    private final CouponDto couponDto;

    public WalletDto(CouponDto couponDto) {
        this.couponDto = couponDto;
    }

    public String getCouponUsedCount() {
        return couponDto.getUsedCount();
    }
}
