package coffee.order.domain.order;

import java.util.ArrayList;
import java.util.List;

public class Orders {

    private List<Order> orders;

    public Orders() {
        this.orders = new ArrayList<>();
    }

    public void addOrder(Order order) {
        orders.add(order);
    }

}
