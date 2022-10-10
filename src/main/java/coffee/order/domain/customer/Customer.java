package coffee.order.domain.customer;

import coffee.order.domain.customer.wallet.Wallet;
import coffee.order.domain.receipt.Receipt;
import coffee.order.domain.order.Orders;
import coffee.order.dto.customer.CustomerDto;

import static coffee.order.exception.CustomerException.CUSTOMER_NOT_ENOUGH_MONEY;

public class Customer {

    private Phone phone;
    private final Wallet wallet;

    public Customer() {
        this.phone = new Phone();
        this.wallet = new Wallet();
    }

    public CustomerDto toCustomerDto() {
        return new CustomerDto(phone.toPhoneDto(), wallet.toWalletDto());
    }

    public int findCouponQuantity() {
        return wallet.findCouponQuantity();
    }

    public boolean checkCouponEnough() {
        return wallet.checkCouponEnoughToUse();
    }

    public void useCoupon() {
        wallet.useCoupon();
    }

    public void takeReceipt(Receipt kioskReceipt) {
        wallet.addReceipt(kioskReceipt);
    }

    public void order(Orders orders) {
        if (checkNotEnoughMoney(orders)) {
            throw new IllegalArgumentException(CUSTOMER_NOT_ENOUGH_MONEY.getMessage());
        }
    }

    public void savePhoneNumber(String phoneNumber) {
        phone = new Phone(phoneNumber);
    }

    public void saveCoupon() {
        wallet.increaseCouponQuantity();
    }

    public Phone answerPhoneNumber() {
        return phone;
    }

    private boolean checkNotEnoughMoney(Orders orders) {
        return wallet.getMyCash() - orders.getTotalPrice() < 0;
    }

}
