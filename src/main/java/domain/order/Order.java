package domain.order;

import java.math.BigDecimal;
import domain.menu.MenuItem;

public class Order implements Comparable<Order> {

    private final MenuItem menuItem;
    private final int count;
    private BigDecimal price;
    private boolean usedCoupon;

    public Order(MenuItem menuItem, int count) {
        this.menuItem = menuItem;
        this.count = count;
        this.usedCoupon = false;
        this.price = menuItem.getPrice().multiply(BigDecimal.valueOf(count));
    }

    public BigDecimal getPrice() {
        return price;
    }

    public MenuItem getMenuItem() {
        return menuItem;
    }

    public int getCount() {
        return count;
    }

    public void applyCoupon() {
        this.usedCoupon = true;
        price = price.subtract(menuItem.getPrice());
    }

    public boolean isUsedCoupon() {
        return usedCoupon;
    }

    @Override
    public int compareTo(Order order) {
        if (menuItem.getMenuCategory() == order.menuItem.getMenuCategory()) {
            return menuItem.getMenuNumber() - order.menuItem.getMenuNumber();
        }
        return menuItem.getMenuCategory().getCategoryNumber() -
                order.menuItem.getMenuCategory().getCategoryNumber();
    }
}
