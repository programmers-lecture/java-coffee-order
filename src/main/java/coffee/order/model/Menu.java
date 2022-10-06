package coffee.order.model;

public class Menu {
    private String menuName;
    private int price;

    public Menu(String menuName, int price) {
        this.menuName = menuName;
        this.price = price;
    }

    @Override
    public String toString() {
        return menuName;
    }
}
