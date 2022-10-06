package coffee.order.domain.pos;

import coffee.order.domain.customer.Customer;
import coffee.order.domain.order.Order;
import coffee.order.view.output.pos.KioskCouponHistoryMessage;

import java.util.Map;
import java.util.Optional;

import static coffee.order.domain.customer.Customers.CUSTOMERS_DATA;
import static coffee.order.domain.pos.KioskCommand.YES;
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

    public boolean askCoupon() {
        askSaveCoupon();
        return askUseCoupon();
    }

    // TODO : OutputView
    private void askSaveCoupon() {
        kioskCouponHistory().printWhenAskSaveCoupon();
        kioskCouponHistory().printWhenAskYesOrNo();
        if (checkCustomersCommandYes(customer.commands())) {
            customer = askPhoneNumber();
            customer.saveCoupon();
            kioskCouponHistory().printWhenNoticeCurrentCouponQuantity();
            kioskCouponHistory().printCurrentCouponQuantity(askCouponQuantity());
            kioskCouponHistory().printAfterNoticeCurrentCouponQuantity();
        }
    }

    public String askCouponQuantity() {
        return String.valueOf(customer.findCouponQuantity());
    }

    private boolean askUseCoupon() {
        if (!customer.checkMyCouponEnough()) {
            return false;
        }

        kioskCouponHistory().printWhenAskUseCoupon();
        kioskCouponHistory().printWhenAskYesOrNo();

        if (!checkCustomersCommandYes(customer.commands())) {
            return false;
        }

        customer.useCoupon();
        return true;
    }

    private Customer askPhoneNumber() {
        kioskCouponHistory().printWhenAskPhoneNumber();
        String phoneNumber = customer.commands();
        if (!CUSTOMERS_DATA.checkPhoneNumberExists(phoneNumber)) {
            CUSTOMERS_DATA.saveCustomerWithPhoneNumber(customer, phoneNumber);
        }
        return CUSTOMERS_DATA.findCustomerByPhoneNumber(phoneNumber);
    }

    // TODO : OutputView
    private boolean checkCustomersCommandYes(String command) {
        return command.equals(YES.selectedCommand);
    }

    public Order findOrderPurchasedByCoupon(Map<String, Order> customerOrders) {
        kioskCouponHistory().printKioskToChoose();
        kioskCouponHistory().printToSelectMenuToUseCoupon(customerOrders);
        String customerAnswer = askCustomerToUseCoupon(customer);
        return Optional.of(customerOrders)
                .orElseThrow(() -> new NullPointerException(CUSTOMER_NOT_EXIST_ORDER_FOOD_NUMBER.getMessage()))
                .get(customerAnswer);
    }

    // TODO : OutputView
    private String askCustomerToUseCoupon(Customer customer) {
        return Optional.of(customer.commands())
                .orElseThrow(() -> new IllegalArgumentException(CUSTOMER_NOT_CORRECT_ANSWER.getMessage()));
    }

}
