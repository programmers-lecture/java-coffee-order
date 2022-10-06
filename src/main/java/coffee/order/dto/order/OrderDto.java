package coffee.order.dto.order;

import coffee.order.domain.food.Food;

import static coffee.order.view.output.UnitMessage.COUNT;
import static coffee.order.view.output.UnitMessage.WON;
import static coffee.order.view.output.order.OrderMessage.ORDER_COUPON_USE;

public class OrderDto {

    private final Food food;
    private final Integer quantity;
    private final Integer totalPrice;
    private final Boolean usedCoupon;

    public OrderDto(Food food, Integer quantity, Integer totalPrice, Boolean usedCoupon) {
        this.food = food;
        this.quantity = quantity;
        this.totalPrice = totalPrice;
        this.usedCoupon = usedCoupon;
    }

    public String getFoodName() {
        return this.food.toFoodNameString();
    }

    public Integer getTotalPrice() {
        return totalPrice;
    }

    public String getOrderHistory() {
        return this.toString();
    }

    public String getOrderHistoryWhenUsedCoupon() {
        return food.toFoodNameString() + " " + 1 + COUNT.unit + " " + ORDER_COUPON_USE.message + "\n";
    }

    @Override
    public String toString() {
        return getFoodName() + " " + quantity + COUNT.unit + " " + totalPrice + WON.unit + "\n";
    }

    public boolean checkCouponNotUsedOrNotZeroQuantity() {
        return !usedCoupon ||quantity != 0;
    }

    public boolean checkCouponUsed() {
        return usedCoupon;
    }

}
