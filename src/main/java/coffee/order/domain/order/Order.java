package coffee.order.domain.order;

import coffee.order.domain.food.Food;

import static coffee.order.message.MessageUnit.COUNT;
import static coffee.order.message.MessageUnit.WON;

public class Order {

    private Food food;
    private int quantity;

    public Order(Food food, int quantity) {
        this.food = food;
        this.quantity = quantity;
    }

    protected StringBuilder createOrderHistory() {
        return new StringBuilder()
                .append(this.food.getName())
                .append(" ")
                .append(this.quantity)
                .append(COUNT.unit)
                .append(" ")
                .append(this.sumTotalPrice())
                .append(WON.unit)
                .append("\n");
    }

    protected int sumTotalPrice() {
        return food.getPrice() * quantity;
    }

}
