package coffee.order.domain.customer.wallet;

public class Wallet {

    private Cash cash;
    private Coupon coupon;

    public Wallet() {
        this.cash = new Cash(20000L);
        this.coupon = new Coupon();
    }
}
