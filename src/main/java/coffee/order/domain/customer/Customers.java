package coffee.order.domain.customer;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
import java.util.function.Predicate;

import static coffee.order.exception.CustomerException.CUSTOMER_NO_SUCH_PHONE_NUMBER;

public enum Customers {

    CUSTOMERS_DATA(new HashMap<>());

    private final Map<String, Customer> customers;

    Customers(Map<String, Customer> customers) {
        this.customers = customers;
    }

    public Customer findCustomerByPhoneNumber(String phoneNumber) {
        return findOptionalCustomerByPhoneNumber(phoneNumber)
                .orElseThrow(() -> new NullPointerException(CUSTOMER_NO_SUCH_PHONE_NUMBER.getMessage()))
                .getValue();
    }

    public boolean checkPhoneNumberExists(String phoneNumber) {
        return findOptionalCustomerByPhoneNumber(phoneNumber).isPresent();
    }

    public void saveCustomerWithPhoneNumber(Customer customer, String phoneNumber) {
        customer.savePhoneNumber(phoneNumber);
        customers.put(phoneNumber, customer);
    }

    private Optional<Map.Entry<String, Customer>> findOptionalCustomerByPhoneNumber(String phoneNumber) {
        return customers.entrySet()
                .stream()
                .filter(checkSamePhoneNumber(phoneNumber))
                .findFirst();
    }

    private Predicate<Map.Entry<String, Customer>> checkSamePhoneNumber(String phoneNumber) {
        return customer -> customer.getKey().equals(phoneNumber);
    }

}
