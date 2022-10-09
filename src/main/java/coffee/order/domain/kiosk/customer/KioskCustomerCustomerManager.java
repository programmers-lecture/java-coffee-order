package coffee.order.domain.kiosk.customer;

import coffee.order.domain.customer.Customer;
import coffee.order.view.input.kiosk.KioskCustomerManagerInput;
import coffee.order.view.output.kiosk.KioskCustomerManagerHistoryMessage;

import static coffee.order.domain.customer.Customers.CUSTOMERS_DATA;

public class KioskCustomerCustomerManager {

    private final KioskCustomer kioskCustomer;
    private Customer customer;

    public KioskCustomerCustomerManager(KioskCustomer kioskCustomer) {
        this.customer = new Customer();
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
