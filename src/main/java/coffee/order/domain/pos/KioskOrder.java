package coffee.order.domain.pos;

import coffee.order.domain.customer.Customer;
import coffee.order.domain.food.Food;
import coffee.order.domain.order.Order;
import coffee.order.domain.order.Orders;
import coffee.order.view.output.pos.KioskOrderHistoryMessage;

import static coffee.order.domain.food.FoodCategory.findFoodsByCategoryId;

public class KioskOrder {

    private final Customer customer;

    public KioskOrder(Customer customer) {
        this.customer = customer;
    }

    public KioskOrderHistoryMessage kioskOrderHistory() {
        return new KioskOrderHistoryMessage();
    }

    public Orders askOrder() {
        kioskOrderHistory().printAsksCustomerToSelectMenu();
        kioskOrderHistory().printShowMenuToCustomer();
        return getOrders();
    }

    private Orders getOrders() {
        Orders orders = new Orders();
        while (true) {
            // TODO : OutputView
            String command = customer.commands();
            if (checkEndCommand(command)) break;
            orders.addOrder(createOrder(command));
        }
        kioskOrderHistory().printAfterSelectMenu();
        orders.ordersHistory().printOrders();
        return orders;
    }

    private boolean checkEndCommand(String command) {
        return command.equals("");
    }

    private Order createOrder(String orderCommand) {
        return new Order(
                findFoodByOrderCommand(orderCommand),
                parseOrderCommandToFoodQuantity(orderCommand));
    }

    private Food findFoodByOrderCommand(String orderCommand) {
        Long findCategoryId = parseOrderCommandToFoodCategoryId(orderCommand);
        Long findFoodId = parseOrderCommandToFoodId(orderCommand);

        return findFoodsByCategoryId(findCategoryId)
                .findFoodByFoodId(findFoodId);
    }

    private Long parseOrderCommandToFoodCategoryId(String orderCommand) {
        return Long.parseLong(orderCommand.substring(0, 1));
    }

    private Long parseOrderCommandToFoodId(String orderCommand) {
        return Long.parseLong(orderCommand.substring(2, 3));
    }

    private int parseOrderCommandToFoodQuantity(String orderCommand) {
        return Integer.parseInt(orderCommand.substring(5).trim());
    }
}
