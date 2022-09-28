package coffee.order.domain.pos;

import coffee.order.domain.customer.Customer;

import static coffee.order.domain.customer.Customers.CUSTOMERS_DATA;
import static coffee.order.domain.pos.KioskCommand.YES;
import static coffee.order.message.CouponMessage.*;
import static coffee.order.view.OutputView.print;

public class KioskCoupon {

    public boolean askCoupon(Customer customer) {
        askSaveCoupon(customer);
        return askUseCoupon(customer);
    }

    private void askSaveCoupon(Customer customer) {
        print(KIOSK_ASK_SAVE_COUPON.message);
        print(KIOSK_SELECT_YES_OR_NO.message);
        if (checkCustomersCommandYes(customer.commands())) {
            askPhoneNumber(customer);
            customer.saveCoupon();
            print(KIOSK_NOTICE_CURRENT_COUPON_QUANTITY.message);
            print(String.valueOf(customer.findCouponQuantity()));
            print(KIOSK_NOTICE_CURRENT_COUPON_QUANTITY_LAST_SENTENCE.message);
        }
    }

    private boolean askUseCoupon(Customer customer) {
        print(KIOSK_ASK_USE_COUPON.message);
        print(KIOSK_SELECT_YES_OR_NO.message);
        if (checkCustomersCommandYes(customer.commands())) {
            customer.useCoupon();
            return true;
        }
        return false;
    }

    private void askPhoneNumber(Customer customer) {
        print(KIOSK_ASK_PHONE_NUMBER.message);
        String phoneNumber = customer.commands();
        if (CUSTOMERS_DATA.checkPhoneNumberExists(phoneNumber)) {
            customer = CUSTOMERS_DATA.findCustomerByPhoneNumber(phoneNumber);
        }
        if (!CUSTOMERS_DATA.checkPhoneNumberExists(phoneNumber)) {
            CUSTOMERS_DATA.saveCustomerWithPhoneNumber(customer, phoneNumber);
        }
    }

    private boolean checkCustomersCommandYes(String command) {
        return command.equals(YES.selectedCommand);
    }
}
