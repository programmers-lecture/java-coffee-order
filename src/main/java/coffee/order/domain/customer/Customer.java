package coffee.order.domain.customer;

import coffee.order.domain.customer.wallet.Receipts;
import coffee.order.domain.customer.wallet.Wallet;
import coffee.order.domain.order.Orders;
import coffee.order.view.InputView;

import static coffee.order.exception.CustomerException.CUSTOMER_NOT_ENOUGH_MONEY;

public class Customer {

    private static final Long id = 1L;
    private Phone phone;
    private Wallet wallet;
    private Receipts receipts;

    public Customer() {
        this.phone = new Phone();
        this.wallet = new Wallet();
        this.receipts = new Receipts();
    }

    public String commands() {
        return InputView.read();
    }

    public int findCouponQuantity() {
        return wallet.findCouponQuantity();
    }

    public boolean checkMyCouponEnough() {
        return wallet.checkCouponEnoughToUse();
    }

    public void useCoupon() {
        wallet.useCoupon();
    }

    public void addMyOrder(Orders orders) {
        if (checkNotEnoughMoney(orders)) {
            throw CUSTOMER_NOT_ENOUGH_MONEY.throwMyException();
        }
        receipts.addReceipt(orders);
    }

    public void savePhoneNumber(String phoneNumber) {
        phone = new Phone(phoneNumber);
    }

    public void saveCoupon() {
        wallet.increaseCouponQuantity();
        ;
    }

    private boolean checkNotEnoughMoney(Orders orders) {
        return wallet.getMyCash() - orders.getTotalPrice() < 0;
    }

}
