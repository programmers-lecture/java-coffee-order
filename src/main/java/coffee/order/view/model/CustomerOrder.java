package coffee.order.view.model;

public class CustomerOrder {
    private final int menuTypeIndex;
    private final int menuNameIndex;
    private final int orderQuantity;

    public CustomerOrder(int menuTypeIndex, int menuNameIndex, int orderQuantity) {
        this.menuTypeIndex = menuTypeIndex;
        this.menuNameIndex = menuNameIndex;
        this.orderQuantity = orderQuantity;
    }

    public int getMenuTypeIndex() {
        return menuTypeIndex;
    }

    public int getMenuNameIndex() {
        return menuNameIndex;
    }

    public int getOrderQuantity() {
        return orderQuantity;
    }
}
