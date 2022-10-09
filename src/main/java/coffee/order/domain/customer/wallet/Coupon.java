package coffee.order.domain.customer.wallet;

public class Coupon {

    private int quantity;

    public Coupon() {
        this.quantity = 9;
    }

    protected int getQuantity() {
        return this.quantity;
    }

    protected boolean checkCouponEnoughToUse() {
        return quantity == 10;
    }

    protected void increaseQuantity() {
        this.quantity++;
    }

    protected void setQuantityZero() {
        this.quantity = 0;
    }
}
