package coffee.order.domain.pos;

import coffee.order.domain.customer.Customer;
import coffee.order.domain.order.Order;
import coffee.order.view.input.pos.KioskCouponInput;
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

    public KioskCouponInput kioskCouponInput() {
        return new KioskCouponInput();
    }

    public boolean askCoupon() {
        askSaveCoupon();
        return askUseCoupon();
    }

    private void askSaveCoupon() {
        kioskCouponHistory().printWhenAskSaveCoupon();
        kioskCouponHistory().printWhenAskYesOrNo();
        String customerAnswered = kioskCouponInput().askCustomerYesOrNo();
        if (checkCustomersCommandYes(customerAnswered)) {
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

        String customerAnswered = kioskCouponInput().askCustomerYesOrNo();
        if (!checkCustomersCommandYes(customerAnswered)) {
            return false;
        }

        customer.useCoupon();
        return true;
    }

    private Customer askPhoneNumber() {
        kioskCouponHistory().printWhenAskPhoneNumber();
        String phoneNumber = kioskCouponInput().askCustomerPhoneNumber();
        if (!CUSTOMERS_DATA.checkPhoneNumberExists(phoneNumber)) {
            CUSTOMERS_DATA.saveCustomerWithPhoneNumber(customer, phoneNumber);
        }
        return CUSTOMERS_DATA.findCustomerByPhoneNumber(phoneNumber);
    }

    private boolean checkCustomersCommandYes(String answer) {
        return answer.equals(YES.selectedCommand);
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

}
