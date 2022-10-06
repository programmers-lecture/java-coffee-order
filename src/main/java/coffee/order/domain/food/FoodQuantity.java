package coffee.order.domain.food;

import coffee.order.dto.food.FoodQuantityDto;

import static coffee.order.exception.FoodException.QUANTITY_MINUS_EXCEPTION;

public class FoodQuantity {

    private int quantity;

    public FoodQuantity(int quantity) {
        this.quantity = quantity;
    }

    public FoodQuantityDto toFoodQuantityDto() {
        return new FoodQuantityDto(quantity);
    }

    void increaseQuantity(int inputQuantity) {
        this.quantity += inputQuantity;
    }

    void decreaseQuantity(int inputQuantity) {
        if (checkMinusQuantity(this.quantity - inputQuantity)) {
            throw new IllegalArgumentException(QUANTITY_MINUS_EXCEPTION.getMessage());
        }
        this.quantity -= inputQuantity;
    }

    boolean checkMinusQuantity(int quantity) {
        return quantity < 0;
    }
}
