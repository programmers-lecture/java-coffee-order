package coffee.order.model;

public class Order {
    private final MenuType menuType;
    private final String menuName;
    private final int orderQuantity;
    private final int orderAmount;
    private boolean isCouponApplied;

    public Order(MenuType menuType, String menuName, int orderQuantity, int orderAmount) {
        this.menuType = menuType;
        this.menuName = menuName;
        this.orderQuantity = orderQuantity;
        this.orderAmount = orderAmount;
        isCouponApplied = false;
    }

    public MenuType getMenuType() {
        return menuType;
    }

    public String getMenuName() {
        return menuName;
    }

    public int getOrderQuantity() {
        return orderQuantity;
    }

    public int getOrderAmount() {
        return orderAmount;
    }

    public void applyCoupon() {
        isCouponApplied = true;
    }

    public boolean isCouponApplied() {
        return isCouponApplied;
    }
}
