package cafe;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import menu.MenuItem;

public class Order {
    private Map<MenuItem, Integer> orders;
    private BigDecimal price;

    public Order() {
        this.orders = new HashMap<>();
        this.price = BigDecimal.ZERO;
    }

    public void addOrder(MenuItem menuItem, int count) {
        orders.put(menuItem, count);
        addPrice(menuItem.calculateOrderPrice(count));
    }

    @Override
    public String toString() {
        List<String> result = new ArrayList<>();
        orders.forEach((menuItem, count) -> result.add(menuItem.toString() + " " + count + "개"));
        Collections.sort(result);
        return result.stream().collect(Collectors.joining(" / ")) + " -> 총 " + price + "원";
    }

    public BigDecimal getPrice() {
        return price;
    }

    public Map<MenuItem, Integer> getOrders() {
        return orders;
    }

    private void addPrice(BigDecimal price) {
        this.price = this.price.add(price);
    }
}
