package coffee.order.domain.customer.wallet;

import coffee.order.domain.receipt.Receipt;
import coffee.order.dto.customer.wallet.WalletDto;

public class Wallet {

    private final Cash cash;
    private final Coupon coupon;
    private final CustomerReceipts receipts;

    public Wallet() {
        this.cash = new Cash(Integer.MAX_VALUE);
        this.coupon = new Coupon();
        this.receipts = new CustomerReceipts();
    }

    public WalletDto toWalletDto() {
        return new WalletDto(coupon.toCouponDto());
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

    public void increaseCouponQuantity() {
        this.coupon.increaseQuantity();
    }

    public void addReceipt(Receipt kioskReceipt) {
        receipts.addReceipt(kioskReceipt);
    }
}
