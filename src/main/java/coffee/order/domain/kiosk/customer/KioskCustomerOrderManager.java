package coffee.order.domain.kiosk.customer;

import coffee.order.domain.order.Order;
import coffee.order.domain.order.OrderGenerator;
import coffee.order.domain.order.Orders;
import coffee.order.view.input.kiosk.customer.KioskCustomerOrderManagerInput;
import coffee.order.view.output.kiosk.customer.KioskCustomerOrderManagerHistoryMessage;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public class KioskCustomerOrderManager {

    private final OrderGenerator orderGenerator;

    public KioskCustomerOrderManager() {
        this.orderGenerator = new OrderGenerator();
    }

    public KioskCustomerOrderManagerHistoryMessage kioskOrderHistory() {
        return new KioskCustomerOrderManagerHistoryMessage();
    }

    public KioskCustomerOrderManagerInput kioskOrderInput() {
        return new KioskCustomerOrderManagerInput();
    }

    public Orders getOrders() {
        kioskOrderHistory().printShowMenuToCustomer();

        while (true) {
            String command = kioskOrderInput().askCustomerToChooseFood();
            if (checkEndCommand(command)) break;
            orderGenerator.createTempOrder(command);
        }
        kioskOrderHistory().printAfterSelectMenu();
        return orderGenerator.loadOrders();
    }

    public Map<String, Order> createSelectedMenu(Collection<Order> orders) {
        Map<String, Order> customerOrders = new HashMap<>();
        orders.forEach(order -> customerOrders.put(createSelectNumber(customerOrders), order));
        return customerOrders;
    }

    public Orders loadOrders() {
        return orderGenerator.loadOrders();
    }

    private String createSelectNumber(Map<String, Order> myOrders) {
        return 1 + "-" + (myOrders.size() + 1);
    }

    private boolean checkEndCommand(String command) {
        return command.equals("");
    }

}
