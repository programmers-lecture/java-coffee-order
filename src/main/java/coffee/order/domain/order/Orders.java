package coffee.order.domain.order;

import coffee.order.domain.meals.Menu;
import coffee.order.view.InputView;

import java.util.ArrayList;
import java.util.List;

public class Orders {
    private final List<Order> orders;

    public Orders() {
        orders = new ArrayList<>();
    }

    public void createOrder(Menu menu, int quantity){
        orders.add(new Order(menu,quantity));
    }

    public List<Order> getOrders(){
        return orders;
    }

    public int getTotalPrice(){
        return orders.stream()
                .map(Order::getOrderMenuPrice)
                .reduce(0, Integer::sum);
    }

    public int getOrderCount() {
        return (int) orders.stream()
                .map(Order::getOrderMenuName)
                .count();
    }
}
