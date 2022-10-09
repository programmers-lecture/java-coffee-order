package coffee.order.domain.order;

import coffee.order.domain.food.Food;
import coffee.order.view.output.order.OrderGeneratorHistoryMessage;

import static coffee.order.domain.food.FoodCategory.findFoodsByCategoryId;

public class OrderGenerator {

    private final Orders orders;

    public OrderGenerator() {
        this.orders = new Orders();
    }

    public OrderGeneratorHistoryMessage orderGeneratorHistory() {
        return new OrderGeneratorHistoryMessage(orders.toOrderDto());
    }

    public Orders loadOrders() {
        orderGeneratorHistory().printOrders();
        return orders;
    }

    public void createTempOrder(String orderCommand) {
        createOrder(orderCommand);
    }

    public void createOrder(String orderCommand) {
        Order order = new Order(
                findFoodByOrderCommand(orderCommand),
                parseOrderCommandToFoodQuantity(orderCommand));

        orders.addOrder(order);
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
