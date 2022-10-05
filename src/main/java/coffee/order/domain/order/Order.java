package coffee.order.domain.order;

import coffee.order.domain.food.Food;
import coffee.order.view.output.order.OrderHistoryMessage;

import static coffee.order.view.output.UnitMessage.COUNT;
import static coffee.order.view.output.UnitMessage.WON;

public class Order {

    private final Food food;
    private Integer quantity;
    private Integer totalPrice;
    private Boolean usedCoupon;

    public Order(Food food, int quantity) {
        this.food = food;
        this.quantity = quantity;
        this.totalPrice = changeTotalPrice();
        this.usedCoupon = false;
    }

    public OrderHistoryMessage orderHistory() {
        return new OrderHistoryMessage(this);
    }

    public void changeCouponUsed() {
        --quantity;
        usedCoupon = true;
        this.totalPrice = changeTotalPrice();
    }

    public String getFoodName() {
        return this.food.toFoodNameString();
    }

    Integer getTotalPrice() {
        return totalPrice;
    }

    void changeFoodQuantityByThisOrder() {
        this.food.decreaseQuantity(quantity);
    }

    void changeFoodQuantityWhenDuplicated(Order order) {
        this.quantity += order.quantity;
    }

    private Integer changeTotalPrice() {
        return food.getPrice() * quantity;
    }

    public boolean checkCouponNotUsedOrNotZeroQuantity() {
        return !usedCoupon ||quantity != 0;
    }

    public boolean checkCouponUsed() {
        return usedCoupon;
    }

    @Override
    public String toString() {
        return getFoodName() + " " + quantity + COUNT.unit + " " + changeTotalPrice() + WON.unit + "\n";
    }

}
