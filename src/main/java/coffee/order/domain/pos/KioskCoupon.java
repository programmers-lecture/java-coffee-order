package coffee.order.domain.pos;

import coffee.order.domain.customer.Customer;

import static coffee.order.domain.customer.Customers.CUSTOMERS_DATA;
import static coffee.order.domain.pos.KioskCommand.YES;
import static coffee.order.message.CouponMessage.*;
import static coffee.order.view.OutputView.print;

public class KioskCoupon {

    private Customer customer;

    public KioskCoupon(Customer customer) {
        this.customer = customer;
    }

    public boolean askCoupon() {
        askSaveCoupon();
        return askUseCoupon();
    }

    private void askSaveCoupon() {
        print(KIOSK_ASK_SAVE_COUPON.message);
        print(KIOSK_SELECT_YES_OR_NO.message);
        if (checkCustomersCommandYes(customer.commands())) {
            customer = askPhoneNumber();
            customer.saveCoupon();
            print(KIOSK_NOTICE_CURRENT_COUPON_QUANTITY.message);
            print(String.valueOf(customer.findCouponQuantity()));
            print(KIOSK_NOTICE_CURRENT_COUPON_QUANTITY_LAST_SENTENCE.message);
        }
    }

    private boolean askUseCoupon() {
        if (!customer.checkMyCouponEnough()) return false;

        print(KIOSK_ASK_USE_COUPON.message);
        print(KIOSK_SELECT_YES_OR_NO.message);
        if (checkCustomersCommandYes(customer.commands())) {
            customer.useCoupon();
            return true;
        }
        return false;
    }

    private Customer askPhoneNumber() {
        print(KIOSK_ASK_PHONE_NUMBER.message);
        String phoneNumber = customer.commands();
        if (!CUSTOMERS_DATA.checkPhoneNumberExists(phoneNumber)) {
            CUSTOMERS_DATA.saveCustomerWithPhoneNumber(customer, phoneNumber);
        }
        return CUSTOMERS_DATA.findCustomerByPhoneNumber(phoneNumber);
    }

    private boolean checkCustomersCommandYes(String command) {
        return command.equals(YES.selectedCommand);
    }

    private void findCustomerFromDataByPhoneNumber(String phoneNumber) {
        customer = CUSTOMERS_DATA.findCustomerByPhoneNumber(phoneNumber);
    }
}
