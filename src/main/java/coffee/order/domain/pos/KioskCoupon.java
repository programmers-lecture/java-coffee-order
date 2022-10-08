package coffee.order.domain.pos;

import coffee.order.domain.customer.Customer;
import coffee.order.domain.order.Order;
import coffee.order.view.input.pos.KioskCouponInput;
import coffee.order.view.output.pos.KioskCouponHistoryMessage;

import java.util.Map;
import java.util.Optional;

import static coffee.order.domain.customer.Customers.CUSTOMERS_DATA;
import static coffee.order.domain.pos.KioskCommand.NO;
import static coffee.order.exception.CustomerException.CUSTOMER_NOT_CORRECT_ANSWER;
import static coffee.order.exception.CustomerException.CUSTOMER_NOT_EXIST_ORDER_FOOD_NUMBER;

public class KioskCoupon {

    private Customer customer;

    public KioskCoupon(Customer customer) {
        this.customer = customer;
    }

    public KioskCouponHistoryMessage kioskCouponHistory() {
        return new KioskCouponHistoryMessage();
    }

    public KioskCouponInput kioskCouponInput() {
        return new KioskCouponInput();
    }

    public boolean processCoupon() {
        if (checkCustomersCommandNo(askSaveCoupon())) {
            return false;
        }
        handleCustomerData(askPhoneNumber());
        saveCoupon();

        if (checkCustomerCouponEnough()) {
            return false;
        }
        if (checkCustomersCommandNo(askUseCoupon())) {
            return false;
        }
        useCoupon();

        return true;
    }

    public Order findOrderPurchasedByCoupon(Map<String, Order> customerOrders) {
        kioskCouponHistory().printKioskToChoose();
        kioskCouponHistory().printToSelectMenuToApplyCoupon(customerOrders);
        String customerSelectedMenu = askCustomerMenuNumberToApplyCoupon();
        return Optional.of(customerOrders)
                .orElseThrow(() -> new NullPointerException(CUSTOMER_NOT_EXIST_ORDER_FOOD_NUMBER.getMessage()))
                .get(customerSelectedMenu);
    }

    private String askCustomerMenuNumberToApplyCoupon() {
        return Optional.of(kioskCouponInput().askCustomerMenuNumberToApplyCoupon())
                .orElseThrow(() -> new IllegalArgumentException(CUSTOMER_NOT_CORRECT_ANSWER.getMessage()));
    }

    private void useCoupon() {
        customer.useCoupon();
    }

    private void saveCoupon() {
        customer.saveCoupon();
        kioskCouponHistory().printCurrentCouponQuantity(findCouponQuantity());
    }

    private void handleCustomerData(String customerPhoneNumber) {
        if (checkCustomerNew(customerPhoneNumber)) {
            saveCustomer(customerPhoneNumber);
        }
        customer = findCustomer(customerPhoneNumber);
    }

    private boolean checkCustomerCouponEnough() {
        return !customer.checkCouponEnough();
    }

    private String askSaveCoupon() {
        kioskCouponHistory().printWhenAskSaveCoupon();
        kioskCouponHistory().printWhenAskYesOrNo();
        return kioskCouponInput().askCustomerYesOrNo();
    }

    private String findCouponQuantity() {
        return String.valueOf(customer.findCouponQuantity());
    }

    private String askUseCoupon() {
        kioskCouponHistory().printWhenAskUseCoupon();
        kioskCouponHistory().printWhenAskYesOrNo();

        return kioskCouponInput().askCustomerYesOrNo();
    }

    private String askPhoneNumber() {
        kioskCouponHistory().printWhenAskPhoneNumber();
        return kioskCouponInput().askCustomerPhoneNumber();
    }

    private Customer findCustomer(String phoneNumber) {
        return CUSTOMERS_DATA.findCustomerByPhoneNumber(phoneNumber);
    }

    private void saveCustomer(String phoneNumber) {
        CUSTOMERS_DATA.saveCustomerWithPhoneNumber(customer, phoneNumber);
    }

    private boolean checkCustomerNew(String phoneNumber) {
        return !CUSTOMERS_DATA.checkPhoneNumberExists(phoneNumber);
    }

    private boolean checkCustomersCommandNo(String answer) {
        return answer.equals(NO.selectedCommand);
    }

}
