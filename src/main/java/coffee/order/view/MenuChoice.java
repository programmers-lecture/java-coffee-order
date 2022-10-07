package coffee.order.view;

public class MenuChoice {
    private final int menuType;
    private final int menuName;
    private final int orderQuantity;

    public MenuChoice(int menuType, int menuName, int orderQuantity) {
        this.menuType = menuType;
        this.menuName = menuName;
        this.orderQuantity = orderQuantity;
    }

    public int getMenuType() {
        return menuType;
    }

    public int getMenuName() {
        return menuName;
    }

    public int getOrderQuantity() {
        return orderQuantity;
    }
}
