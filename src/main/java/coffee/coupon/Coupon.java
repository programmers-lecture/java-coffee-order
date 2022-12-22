package coffee.coupon;

import java.util.HashMap;

public class Coupon {
    private final String phoneNumber;
    private int couponNumber;

    private HashMap<String,Integer> couponBook = new HashMap<>();
    {
        couponBook.put("010-0000-0000", 4);
        couponBook.put("010-1234-5677", 10);
        couponBook.put("010-4132-4166", 24);
        couponBook.put("010-3643-7832", 0);
    }

    public Coupon(String phoneNumber, int couponNumber) {
        this.phoneNumber = phoneNumber;
        this.couponNumber = couponNumber;
    }

    //쿠폰 수량조회
    public int couponQuantity(String phoneNumber){
        return 0;
    }
    //쿠폰 사용 가능 여부 확인
    public boolean useCoupon(String phoneNumber){
        return couponQuantity(phoneNumber) >= 10;
    }

    //쿠폰을 적용할 메뉸

}
