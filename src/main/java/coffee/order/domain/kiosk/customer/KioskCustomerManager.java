package coffee.order.domain.kiosk.customer;

import coffee.order.view.input.kiosk.KioskCustomerManagerInput;
import coffee.order.view.output.kiosk.KioskCustomerManagerHistoryMessage;

import static coffee.order.domain.customer.Customers.CUSTOMERS_DATA;

public class KioskCustomerManager {

    private final KioskCustomer kioskCustomer;

    public KioskCustomerManager(KioskCustomer kioskCustomer) {
        this.kioskCustomer = kioskCustomer;
    }

    public KioskCustomerManagerHistoryMessage history() {
        return new KioskCustomerManagerHistoryMessage();
    }

    public KioskCustomerManagerInput input() {
        return new KioskCustomerManagerInput();
    }

    public void findCustomerThenSetting(String phoneNumber) {
        if (checkCustomerNew(phoneNumber)) {
            saveCustomer(phoneNumber);
        }
        kioskCustomer.loginCustomer(phoneNumber);
    }

    public String askPhoneNumber() {
        history().printWhenAskPhoneNumber();
        return input().askCustomerPhoneNumber();
    }

    private void saveCustomer(String phoneNumber) {
        CUSTOMERS_DATA.saveCustomerWithPhoneNumber(kioskCustomer.loadCustomer(), phoneNumber);
    }

    private boolean checkCustomerNew(String phoneNumber) {
        return !CUSTOMERS_DATA.checkPhoneNumberExists(phoneNumber);
    }

}
