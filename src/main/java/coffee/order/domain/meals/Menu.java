package coffee.order.domain.meals;

public class Menu {

    private final Category category;
    private final String serialNumber;
    private final String menuName;
    private final int price;

    public Menu(Category category, String serialNumber, String menuName, int price) {
        this.category = category;
        this.serialNumber = serialNumber;
        this.menuName = menuName;
        this.price = price;
    }

    public String getSerialNumber() {
        return serialNumber;
    }

    public String getMenuName() {
        return menuName;
    }

    public int getPrice() {
        return price;
    }

    public boolean isCategory(Category category){
        return this.category.equals(category);
    }

    @Override
    public String toString() {
        return getSerialNumber()+getMenuName()+getPrice();
    }


}
