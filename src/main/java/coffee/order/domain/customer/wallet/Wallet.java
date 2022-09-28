package coffee.order.domain.customer.wallet;

public class Wallet {

    private Cash cash;
    private Coupon coupon;

    public Wallet() {
        this.cash = new Cash(20000);
        this.coupon = new Coupon();
    }

    public int getMyCash() {
        return this.cash.getCash();
    }

    public void spend(int money) {
        this.cash.spend(money);
    }
}
