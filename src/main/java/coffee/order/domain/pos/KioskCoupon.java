package coffee.order.domain.pos;

import coffee.order.domain.customer.Customer;
import coffee.order.view.output.pos.KioskCouponHistoryMessage;

import static coffee.order.domain.customer.Customers.CUSTOMERS_DATA;
import static coffee.order.domain.pos.KioskCommand.YES;

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

    private boolean checkCustomersCommandYes(String command) {
        return command.equals(YES.selectedCommand);
    }

}
