package coffee.order.domain.pos;

import coffee.order.domain.customer.Customer;
import coffee.order.domain.food.Food;
import coffee.order.domain.order.Order;
import coffee.order.domain.order.Orders;

import static coffee.order.domain.food.FoodCategory.findFoodsByCategoryId;
import static coffee.order.domain.food.FoodCategory.getMenuMessage;
import static coffee.order.message.InputMessage.INPUT_CUSTOMER_SELECT_MENU;
import static coffee.order.view.OutputView.print;

public class KioskOrder {

    public void askOrder(Customer customer) {
        print(INPUT_CUSTOMER_SELECT_MENU.message);
        print(getMenuMessage());
        customer.addMyOrder(getOrders(customer));
    }

    private Orders getOrders(Customer customer) {
        Orders orders = new Orders();
        while (true) {
            String command = customer.commands();
            if (command.equals("")) break;
            orders.addOrder(createOrder(command));
        }
        return orders;
    }

    private Order createOrder(String orderCommand) {
        return new Order(
                findFoodByCategoryIdAndFoodId(
                        findFoodCategoryId(orderCommand),
                        findFoodId(orderCommand)
                ),
                findOrderedFoodQuantity(orderCommand),
                false);
    }

    private Food findFoodByCategoryIdAndFoodId(Long foodCategoryId, Long foodId) {
        return findFoodsByCategoryId(foodCategoryId)
                .findFoodByFoodId(foodId);
    }

    private Long findFoodCategoryId(String orderCommand) {
        return Long.parseLong(orderCommand.substring(0, 1));
    }

    private Long findFoodId(String orderCommand) {
        return Long.parseLong(orderCommand.substring(2, 3));
    }

    private int findOrderedFoodQuantity(String orderCommand) {
        return Integer.parseInt(orderCommand.substring(5).trim());
    }
}
