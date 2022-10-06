package coffee.order.view;

public class MenuChoice {
    private final int menuType;
    private final int menuName;
    private final int orderAmount;

    public MenuChoice(int menuType, int menuName, int orderAmount) {
        this.menuType = menuType;
        this.menuName = menuName;
        this.orderAmount = orderAmount;
    }

    public int getMenuType() {
        return menuType;
    }

    public int getMenuName() {
        return menuName;
    }

    public int getOrderAmount() {
        return orderAmount;
    }
}
