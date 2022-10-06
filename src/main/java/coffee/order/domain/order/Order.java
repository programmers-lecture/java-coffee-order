package coffee.order.domain.order;

import coffee.order.domain.food.Food;
import coffee.order.dto.order.OrderDto;

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

    public OrderDto toOrderDto() {
        return new OrderDto(
                food.toFoodDto(),
                quantity.intValue(),
                totalPrice.intValue(),
                usedCoupon.booleanValue());
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

}
