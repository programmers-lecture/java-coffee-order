package coffee.order.domain.customer.wallet;

public class Wallet {

    private Cash cash;
    private Coupon coupon;

    public Wallet() {
        this.cash = new Cash(20000);
        this.coupon = new Coupon();
    }

    public boolean checkCouponEnoughToUse() {
        return this.coupon.checkCouponEnoughToUse();
    }

    public int getMyCash() {
        return this.cash.getCash();
    }

    public void useCoupon() {
        this.coupon.setQuantityZero();
    }

    public int findCouponQuantity() {
        return this.coupon.getQuantity();
    }

    public void spend(int money) {
        this.cash.spend(money);
    }

    public void increaseCouponQuantity() {
        this.coupon.increaseQuantity();
    }
}
