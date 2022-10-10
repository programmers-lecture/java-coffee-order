package coffee.order.model;

public class Order {
    private final MenuType menuType;
    private final String menuName;
    private final int orderQuantity;
    private final int orderAmount;

    public Order(MenuType menuType, String menuName, int orderQuantity, int orderAmount) {
        this.menuType = menuType;
        this.menuName = menuName;
        this.orderQuantity = orderQuantity;
        this.orderAmount = orderAmount;
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
}
