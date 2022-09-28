package coffee.order.domain.pos;

import coffee.order.domain.customer.Customer;
import coffee.order.domain.food.Food;
import coffee.order.domain.order.Order;
import coffee.order.domain.order.Orders;

import static coffee.order.domain.food.FoodCategory.findTypeFoodsByCategoryId;

public class Kiosk {

    public void takeOrders(Customer customer) {
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
        return findTypeFoodsByCategoryId(foodCategoryId)
                .findFoodByFoodId(foodId);
    }

    private Long findFoodCategoryId(String orderCommand) {
        return Long.parseLong(orderCommand.substring(0, 1));
    }

    private Long findFoodId(String orderCommand) {
        return Long.parseLong(orderCommand.substring(2, 3));
    }

    private int findOrderedFoodQuantity(String orderCommand) {
        return Integer.parseInt(orderCommand.substring(6).trim());
    }

    private void askSaveCoupon() {

    }

}
