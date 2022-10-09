package coffee.order.domain.kiosk.customer;

import coffee.order.domain.customer.Customer;
import coffee.order.view.input.kiosk.customer.KioskCustomerCustomerManagerInput;
import coffee.order.view.output.kiosk.customer.KioskCustomerCustomerManagerHistoryMessage;

import static coffee.order.domain.customer.Customers.CUSTOMERS_DATA;

public class KioskCustomerCustomerManager {

    private final KioskCustomer kioskCustomer;
    private Customer customer;

    public KioskCustomerCustomerManager(KioskCustomer kioskCustomer) {
        this.customer = new Customer();
        this.kioskCustomer = kioskCustomer;
    }

    public KioskCustomerCustomerManagerHistoryMessage history() {
        return new KioskCustomerCustomerManagerHistoryMessage();
    }

    public KioskCustomerCustomerManagerInput input() {
        return new KioskCustomerCustomerManagerInput();
    }

    public void findCustomerThenSetting(String phoneNumber) {
        if (checkCustomerNew(phoneNumber)) {
            saveCustomer(phoneNumber);
        }
        loginCustomer(phoneNumber);
    }

    public String askPhoneNumber() {
        history().printWhenAskPhoneNumber();
        return input().askCustomerPhoneNumber();
    }

    public Customer loadCustomer() {
        return customer;
    }

    private void saveCustomer(String phoneNumber) {
        CUSTOMERS_DATA.saveCustomerWithPhoneNumber(kioskCustomer.loadCustomer(), phoneNumber);
    }

    private boolean checkCustomerNew(String phoneNumber) {
        return !CUSTOMERS_DATA.checkPhoneNumberExists(phoneNumber);
    }

    private void loginCustomer(String phoneNumber) {
        customer = CUSTOMERS_DATA.findCustomerByPhoneNumber(phoneNumber);
    }
}
