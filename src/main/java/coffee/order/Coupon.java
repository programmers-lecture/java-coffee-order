package coffee.order;

public class Coupon {
    static int stampCount = 0;
    static int couponCount = 0; //스탬프 10장이 모이면 1이 올라간다.
    static String target = "";

    public static int saveStamps(int qty) {
        stampCount += qty;

        if(stampCount > 10) {
            couponCount = (int)(stampCount / 10);
            stampCount = stampCount % 10;
            System.out.println("쿠폰 " + couponCount + "장이 발급되었습니다.");
        }

        return couponCount;
    }

    public static int useCoupon(int qty) {
        couponCount -= qty;
        System.out.println("쿠폰 " + qty + "장이 사용되었습니다. 남은 스탬프는 " + stampCount + "개 입니다.");
        return stampCount;
    }

    public static int getStampCount() {
        return stampCount;
    }

    public static int getCouponCount() {
        return couponCount;
    }
}
