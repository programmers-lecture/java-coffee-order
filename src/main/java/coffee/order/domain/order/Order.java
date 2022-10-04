package coffee.order.domain.order;

import coffee.order.domain.food.Food;

import static coffee.order.message.CouponMessage.KIOSK_COUPON_USE;
import static coffee.order.message.MessageUnit.COUNT;
import static coffee.order.message.MessageUnit.WON;

public class Order {

    private Food food;
    private Integer quantity;
    private Integer totalPrice;
    private Boolean usedCoupon;

    public Order(Food food, int quantity) {
        this.food = food;
        this.quantity = quantity;
        this.totalPrice = changeTotalPrice();
        this.usedCoupon = false;
    }

    public void changeCouponUsed() {
        --quantity;
        usedCoupon = true;
        this.totalPrice = changeTotalPrice();
    }

    Integer getTotalPrice() {
        return totalPrice;
    }

    private Integer changeTotalPrice() {
        return food.getPrice() * quantity;
    }

    protected String getFoodName() {
        return this.food.toFoodNameString();
    }

    protected StringBuilder createOrderHistory() {
        StringBuilder orderHistoryBuilder = new StringBuilder();
        createHistoryWhenCouponUsed(orderHistoryBuilder);
        createHistory(orderHistoryBuilder);
        return orderHistoryBuilder;
    }

    protected void changeFoodQuantityByThisOrder() {
        this.food.decreaseQuantity(quantity);
    }

    protected void changeFoodQuantityWhenDuplicated(Order order) {
        this.quantity += order.quantity;
    }

    private void createHistory(StringBuilder orderHistoryBuilder) {
        if (!usedCoupon || quantity != 0) {
            orderHistoryBuilder
                    .append(food.toFoodNameString())
                    .append(" ")
                    .append(quantity)
                    .append(COUNT.unit)
                    .append(" ")
                    .append(changeTotalPrice())
                    .append(WON.unit)
                    .append("\n");
        }
    }

    private void createHistoryWhenCouponUsed(StringBuilder orderHistoryBuilder) {
        if (usedCoupon) {
            orderHistoryBuilder
                    .append(food.toFoodNameString())
                    .append(" ")
                    .append(1)
                    .append(COUNT.unit)
                    .append(" ")
                    .append(KIOSK_COUPON_USE.message)
                    .append("\n");
        }
    }

}
