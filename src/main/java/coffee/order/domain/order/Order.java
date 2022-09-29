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
    }

    protected int sumTotalPrice() {
        int totalPrice = food.getFoodTotalPrice(quantity);
        if (usedCoupon) {
            totalPrice -= food.getFoodTotalPrice(1);
        }
        return totalPrice;
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

    private void createHistory(StringBuilder orderHistoryBuilder) {
        if (!usedCoupon || quantity != 1) {
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
