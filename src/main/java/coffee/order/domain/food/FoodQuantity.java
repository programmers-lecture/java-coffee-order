package coffee.order.domain.food;

import static coffee.order.exception.FoodException.QUANTITY_MINUS_EXCEPTION;

public class FoodQuantity {

    private int quantity;

    public FoodQuantity(int quantity) {
        this.quantity = quantity;
    }

    protected void increaseQuantity(int inputQuantity) {
        this.quantity += inputQuantity;
    }

    protected void decreaseQuantity(int inputQuantity) {
        if (checkMinusQuantity(this.quantity - inputQuantity)) {
            throw new IllegalArgumentException(QUANTITY_MINUS_EXCEPTION.getMessage());
        }
        this.quantity -= inputQuantity;
    }

    protected boolean checkMinusQuantity(int quantity) {
        return quantity < 0;
    }
}
