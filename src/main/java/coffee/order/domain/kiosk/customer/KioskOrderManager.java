package coffee.order.domain.kiosk.customer;

import coffee.order.domain.order.Order;
import coffee.order.domain.order.OrderGenerator;
import coffee.order.domain.order.Orders;
import coffee.order.view.input.kiosk.KioskOrderManagerInput;
import coffee.order.view.output.kiosk.KioskOrderManagerHistoryMessage;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public class KioskOrderManager {

    private final OrderGenerator orderGenerator;
    private final KioskCustomer kioskCustomer;

    public KioskOrderManager(KioskCustomer kioskCustomer) {
        this.orderGenerator = new OrderGenerator();
        this.kioskCustomer = kioskCustomer;
    }

    public KioskOrderManagerHistoryMessage kioskOrderHistory() {
        return new KioskOrderManagerHistoryMessage();
    }

    public KioskOrderManagerInput kioskOrderInput() {
        return new KioskOrderManagerInput();
    }

    public Orders getOrders() {
        kioskOrderHistory().printAsksCustomerToSelectMenu();
        kioskOrderHistory().printShowMenuToCustomer();

        while (true) {
            String command = kioskOrderInput().askCustomerToChooseFood();
            if (checkEndCommand(command)) break;
            kioskCustomer.createTempOrder(command);
        }
        kioskOrderHistory().printAfterSelectMenu();
        return kioskCustomer.generateOrders();
    }

    public Map<String, Order> createSelectedMenu(Collection<Order> orders) {
        Map<String, Order> customerOrders = new HashMap<>();
        orders.forEach(order -> customerOrders.put(createSelectNumber(customerOrders), order));
        return customerOrders;
    }

    public Orders loadOrders() {
        return orderGenerator.loadOrders();
    }

    public void createOrder(String orderCommand) {
        orderGenerator.createOrder(orderCommand);
    }

    private String createSelectNumber(Map<String, Order> myOrders) {
        return 1 + "-" + (myOrders.size() + 1);
    }

    private boolean checkEndCommand(String command) {
        return command.equals("");
    }

}
