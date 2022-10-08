package coffee.order.model;

public class Transaction {
    private final MenuType menuType;
    private final String menuName;
    private final int orderQuantity;
    private final int orderAmount;

    public Transaction(MenuType menuType, String menuName, int orderQuantity, int orderAmount) {
        this.menuType = menuType;
        this.menuName = menuName;
        this.orderQuantity = orderQuantity;
        this.orderAmount = orderAmount;
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
