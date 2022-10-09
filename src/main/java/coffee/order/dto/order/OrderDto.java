package coffee.order.dto.order;

import coffee.order.dto.food.FoodDto;

import static coffee.order.view.output.UnitMessage.COUNT;
import static coffee.order.view.output.UnitMessage.WON;
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
        return foodDto.getName() + " " + 1 + COUNT.unit + " " + ORDER_COUPON_USE.message + "\n";
    }

    @Override
    public String toString() {
        return foodDto.getName() + " " + quantity + COUNT.unit + " " + totalPrice + WON.unit + "\n";
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
        foodDto.getName();
    }

}
