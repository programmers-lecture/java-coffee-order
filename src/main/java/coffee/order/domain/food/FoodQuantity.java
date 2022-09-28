package coffee.order.domain.food;

import static coffee.order.exception.FoodException.*;

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
            throw QUANTITY_MINUS_EXCEPTION.throwMyException();
        }
        this.quantity -= inputQuantity;
    }

    private boolean checkMinusQuantity(int quantity) {
        return quantity < 0;
    }
}
