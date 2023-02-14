package domain.order;

import domain.menu.MenuCategory;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import io.output.Output;

public class OrderList {

    private final List<Order> orders;

    public OrderList() {
        this.orders = new ArrayList<>();
    }

    public void addOrder(Order order) {
        orders.add(order);
    }

    public String showOrderForOrderHistory() {
        List<String> result = new ArrayList<>();
        orders.forEach(order -> {
                    if (order.isUsedCoupon()) {
                        result.add(order.getMenuItem().getMenuCategory().getCategoryNumber()
                                + "-"
                                + order.getMenuItem().getMenuNumber()
                                + " "
                                + order.getMenuItem().getMenuCategory().getCategoryName()
                                + " "
                                + order.getCount()
                                + "개"
                                + "(쿠폰사용)");
                    }
                    if (!order.isUsedCoupon()) {
                        result.add(order.getMenuItem().getMenuCategory().getCategoryNumber()
                                + "-"
                                + order.getMenuItem().getMenuNumber()
                                + " "
                                + order.getMenuItem().getMenuCategory().getCategoryName()
                                + " "
                                + order.getCount()
                                + "개");
                    }
                }
        );
        Collections.sort(result);
        return result.stream().collect(Collectors.joining(" / ")) + " -> 총 " + getPrice() + "원";
    }

    public String showOrderForOrderList() {
        List<String> result = new ArrayList<>();
        Collections.sort(orders);
        orders.forEach(order -> {
                    if (order.isUsedCoupon()) {
                        result.add(order.getMenuItem().getMenuName()
                                + " "
                                + order.getCount()
                                + "개"
                                + " "
                                + order.getPrice()
                                + "원"
                                + "(쿠폰사용)"
                        );
                    }
                    if (!order.isUsedCoupon()) {
                        result.add(order.getMenuItem().getMenuName()
                                + " "
                                + order.getCount()
                                + "개"
                                + " "
                                + order.getPrice()
                                + "원");
                    }
                }
        );
        return result.stream().collect(Collectors.joining("\n"));
    }

    public void showOrderForUseCoupon() {
        List<String> result = new ArrayList<>();
        Collections.sort(orders);
        orders.forEach(order -> result.add(order.getMenuItem().getMenuCategory().getCategoryNumber()
                        + "-"
                        + order.getMenuItem().getMenuNumber()
                        + ". "
                        + order.getMenuItem().getMenuCategory().getCategoryName()
                )
        );
        Output.printOrderForUseCoupon(result.stream().collect(Collectors.joining("\n")));
    }

    public BigDecimal getPrice() {
        BigDecimal price = BigDecimal.ZERO;
        for (Order order : orders) {
            price = price.add(order.getPrice());
        }
        return price;
    }

    public Order getOrder(MenuCategory menuCategory, int menuNumber) {
        return orders.stream().filter(order -> order.getMenuItem().getMenuCategory() == menuCategory
                        && order.getMenuItem().getMenuNumber() == menuNumber)
                .findAny()
                .orElseThrow(() -> new IllegalArgumentException("일치하는 주문이 없습니다."));
    }

    public List<Order> getOrders() {
        return orders;
    }
}
