package coffee.order.domain.customer.wallet;

public class Wallet {

    private Cash cash;
    private Coupon coupon;

    public Wallet(Cash cash, Coupon coupon) {
        this.cash = cash;
        this.coupon = coupon;
    }
}
