package coffee.order.models;

public class Coupon {
    private static final int COUPON_USE_COUNT = 10;
    private static final int COUPON_INIT_COUNT = 0;

    private int count;

    public Coupon() {
        this.count = COUPON_INIT_COUNT;
    }

    public static boolean isCouponUsePossible(int couponsCnt) {
        return couponsCnt >= COUPON_USE_COUNT;
    }

    public void addCouponCnt(int count) {
        if(count < 0)
            throw new IllegalArgumentException("적립할 쿠폰의 갯수는 음수가 될 수 없습니다.");
        this.count += count;
    }
    public int useCoupon(int orderCnt) {
        int couponUsableCnt = Math.min(count / COUPON_USE_COUNT, orderCnt);
        count -= COUPON_USE_COUNT * couponUsableCnt;
        return couponUsableCnt;
    }

    public int getCount() {
        return count;
    }
}
