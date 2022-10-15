package coffee.order.domain.customer.wallet;

import coffee.order.dto.customer.wallet.CouponDto;

public class Coupon {

    private Integer quantity;
    private Integer usedCount;

    public Coupon() {
        this.quantity = 0;
        this.usedCount = 0;
    }

    public CouponDto toCouponDto() {
        return new CouponDto(quantity, usedCount);
    }

    protected int getQuantity() {
        return this.quantity;
    }

    protected boolean checkCouponEnoughToUse() {
        return quantity >= 10;
    }

    protected void increaseQuantity() {
        this.quantity++;
    }

    protected void setQuantityZero() {
        this.quantity -= 10;
        this.usedCount = this.usedCount.intValue() + 1;
    }
}
