package coffee.order.models;

public class Coupon {
    private static final int COUPON_USE_COUNT = 10;

    private int count;

    public Coupon(int count) {
        this.count = count;
    }

    public int getCount() {
        return this.count;
    }

    public boolean isCouponUsePossible() {
        return count >= COUPON_USE_COUNT;
    }

    public void useCoupon() {
        count -= COUPON_USE_COUNT;
    }
}
