package coffee.order;

public class Coupon {

    public int couponQuantity(String phoneNumber){
        return 0;
    }

    public boolean useCoupon(String phoneNumber){
        return couponQuantity(phoneNumber) >= 10;
    }

}
