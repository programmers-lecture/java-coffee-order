package coffee.order.model;

public class Transaction {
    private final MenuType menuType;
    private final String menuName;
    private final int orderAmount;

    public Transaction(MenuType menuType, String menuName, int orderAmount) {
        this.menuType = menuType;
        this.menuName = menuName;
        this.orderAmount = orderAmount;
    }
}
