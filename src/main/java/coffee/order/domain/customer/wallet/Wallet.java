package coffee.order.domain.customer.wallet;

import coffee.order.domain.order.Orders;

public class Wallet {

    private final Cash cash;
    private final Coupon coupon;
    private final Receipts receipts;

    public Wallet() {
        this.cash = new Cash(Integer.MAX_VALUE);
        this.coupon = new Coupon();
        this.receipts = new Receipts();
    }

    public boolean checkCouponEnoughToUse() {
        return this.coupon.checkCouponEnoughToUse();
    }

    public int getMyCash() {
        return this.cash.getCash();
    }

    public int findCouponQuantity() {
        return this.coupon.getQuantity();
    }

    public void useCoupon() {
        this.coupon.setQuantityZero();
    }

    public void spend(int money) {
        this.cash.spend(money);
    }

    public void increaseCouponQuantity() {
        this.coupon.increaseQuantity();
    }

    public void addReceipt(Orders orders) {
        receipts.addReceipt(orders);
    }
}
