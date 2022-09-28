package coffee.order.models;

public class Coupon {
    private static final int COUPON_USE_COUNT = 10;
    private static final int COUPON_INIT_COUNT = 1;
    private static final int COUPON_EARN_COUNT = 1;

    private String phoneNumber;
    private int count;

    public Coupon(String phoneNumber) {
        this.phoneNumber = phoneNumber;
        this.count = COUPON_INIT_COUNT;
    }

    public String getPhoneNumber() {
        return this.phoneNumber;
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

    public void earnCoupon() {
        count += COUPON_EARN_COUNT;
    }
}
