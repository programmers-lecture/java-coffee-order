package coffee.order.domain.pos;

import coffee.order.domain.customer.Customer;
import coffee.order.domain.food.Food;
import coffee.order.domain.food.FoodCategory;
import coffee.order.domain.order.Order;
import coffee.order.domain.order.Orders;

import java.util.Arrays;

import static coffee.order.domain.food.FoodCategory.*;
import static coffee.order.domain.food.FoodCategory.findFoodsByCategoryId;
import static coffee.order.message.InputMessage.INPUT_CUSTOMER_SELECT_MENU;
import static coffee.order.view.OutputView.print;

public class Kiosk {

    public void takeOrders(Customer customer) {
        print(INPUT_CUSTOMER_SELECT_MENU.message);
        print(getMenuMessage());
        Orders orders = new Orders();
        orders.addOrder(makeOrder(customer.order()));
        customer.addMyOrder(orders);
    }

    private Order makeOrder(String orderCommand) {
        return new Order(
                findFoodByCategoryIdAndFoodId(
                        findFoodCategoryId(orderCommand),
                        findFoodId(orderCommand)
                ),
                findOrderedFoodQuantity(orderCommand));
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

    private void askSaveCoupon() {

    }

}
