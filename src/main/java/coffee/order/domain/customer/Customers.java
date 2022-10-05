package coffee.order.domain.customer;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

import static coffee.order.exception.CustomerException.CUSTOMER_NO_SUCH_PHONE_NUMBER;

public enum Customers {

    CUSTOMERS_DATA(new HashMap<>());

    private final Map<String, Customer> customers;

    Customers(Map<String, Customer> customers) {
        this.customers = customers;
    }

    public Customer findCustomerByPhoneNumber(String phoneNumber) {
        return findOptionalCustomer(phoneNumber)
                .orElseThrow(() -> new NullPointerException(CUSTOMER_NO_SUCH_PHONE_NUMBER.getMessage()))
                .getValue();
    }

    private Optional<Map.Entry<String, Customer>> findOptionalCustomer(String phoneNumber) {
        return customers.entrySet()
                .stream()
                .filter(customer -> customer.getKey().equals(phoneNumber))
                .findFirst();
    }

    public boolean checkPhoneNumberExists(String phoneNumber) {
        return findOptionalCustomer(phoneNumber).isPresent();
    }

    public void saveCustomerWithPhoneNumber(Customer customer, String phoneNumber) {
        customer.savePhoneNumber(phoneNumber);
        customers.put(phoneNumber, customer);
    }
}
