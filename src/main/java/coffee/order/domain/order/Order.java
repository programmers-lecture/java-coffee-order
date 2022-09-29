package coffee.order.domain.order;

import coffee.order.domain.food.Food;

import static coffee.order.message.CouponMessage.KIOSK_COUPON_USE;
import static coffee.order.message.MessageUnit.COUNT;
import static coffee.order.message.MessageUnit.WON;

public class Order {

    private Food food;
    private int quantity;
    private boolean usedCoupon;

    public Order(Food food, int quantity) {
        this.food = food;
        this.quantity = quantity;
        this.usedCoupon = false;
    }

    public void changeCouponUsed() {
        usedCoupon = true;
        --quantity;
    }

    protected int sumTotalPrice() {
        return food.getFoodTotalPrice(quantity);
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
                    .append(sumTotalPrice())
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
