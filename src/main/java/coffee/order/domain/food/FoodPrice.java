package coffee.order.domain.food;

import static coffee.order.exception.FoodException.PRICE_MINUS_EXCEPTION;

public class FoodPrice {

    private int price;

    public FoodPrice(int price) {
        this.price = price;
    }

    protected int getPrice() {
        return this.price;
    }

    protected void increasePrice(int inputPrice) {
        this.price += inputPrice;
    }

    protected void decreasePrice(int inputPrice) {
        if (checkMinusPrice(this.price - inputPrice)) {
            throw PRICE_MINUS_EXCEPTION.throwMyException();
        }
        this.price -= inputPrice;
    }

    private boolean checkMinusPrice(int price) {
        return price < 0;
    }
}
