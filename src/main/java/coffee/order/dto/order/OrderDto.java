package coffee.order.dto.order;

import coffee.order.dto.food.FoodDto;

import static coffee.order.view.output.UnitMessage.*;
import static coffee.order.view.output.order.OrderMessage.ORDER_COUPON_USE;

public class OrderDto {

    private final FoodDto foodDto;
    private final Integer quantity;
    private final Integer totalPrice;
    private final Boolean usedCoupon;

    public OrderDto(FoodDto food, Integer quantity, Integer totalPrice, Boolean usedCoupon) {
        this.foodDto = food;
        this.quantity = quantity;
        this.totalPrice = totalPrice;
        this.usedCoupon = usedCoupon;
    }

    public String getOrderHistory() {
        return this.toString();
    }

    public String getOrderHistoryWhenUsedCoupon() {
        return foodDto.getName() +
                SPACE.unit +
                1 +
                COUNT.unit +
                SPACE.unit +
                ORDER_COUPON_USE.message +
                ENTER.unit;
    }

    @Override
    public String toString() {
        return foodDto.getName() +
                SPACE.unit +
                quantity +
                COUNT.unit +
                SPACE.unit +
                totalPrice +
                WON.unit +
                ENTER.unit;
    }

    public boolean checkCouponNotUsedOrNotZeroQuantity() {
        return !usedCoupon ||quantity != 0;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public Integer getTotalPrice() {
        return totalPrice;
    }

    public boolean checkCouponUsed() {
        return usedCoupon;
    }

    public String getMenuNumber() {
        return foodDto.getCategoryId() + "-" + foodDto.getId();
    }

    public String getFoodName() {
        return foodDto.getName().toString();
    }

}
