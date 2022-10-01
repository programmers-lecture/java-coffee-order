package coffee.order;

import coffee.order.controller.Customer;

public class Main {
    public static void main(String[] args) {
        Customer customer = new Customer();
        customer.doOrder();
    }
}