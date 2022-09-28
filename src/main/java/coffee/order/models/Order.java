package coffee.order.models;

import coffee.order.enums.Coffee;
import coffee.order.enums.Dessert;
import coffee.order.enums.Tea;

public class Order {
    private String menuNumber;
    private int count;
    private String menuName;
    private int menuPrice;
    private boolean isCouponUsed;

    public Order(String menuNumber, int count) {
        this.menuNumber = menuNumber;
        this.count = count;
        this.isCouponUsed = false;
        saveOrderInfo();
    }

    public void saveOrderInfo() {
        Coffee coffee = Coffee.findCoffee(menuNumber);
        if(coffee != null) {
            menuName = coffee.getName();
            menuPrice = coffee.getPrice();
            return;
        }
        Tea tea = Tea.findTea(menuNumber);
        if(tea != null) {
            menuName = tea.getName();
            menuPrice = tea.getPrice();
            return;
        }
        Dessert dessert = Dessert.findDessert(menuNumber);
        if(dessert != null)  {
            menuName = dessert.getName();
            menuPrice = dessert.getPrice();
            return;
        }
        throw new IllegalArgumentException("주문에 해당되는 메뉴가 존재하지 않습니다.");
    }

    public void useCouponForOrder() {
        this.isCouponUsed = true;
    }

    public String getMenuNumber() {
        return this.menuNumber;
    }

    public String getMenuName() {
        return this.menuName;
    }

    public int getCount() {
        return this.count;
    }

    public int getMenuPrice() {
        return this.menuPrice;
    }

    public boolean getIsCouponUsed() {
        return this.isCouponUsed;
    }
}
