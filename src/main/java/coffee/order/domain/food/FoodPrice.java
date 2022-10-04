package coffee.order.domain.food;

import static coffee.order.exception.FoodException.PRICE_MINUS_EXCEPTION;

public class FoodPrice {

    // Integer Null
    private int price;

    public FoodPrice(int price) {
        this.price = price;
    }

    protected int getPrice() {
        return price;
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

    protected boolean checkMinusPrice(int price) {
        return price < 0;
    }

    @Override
    public String toString() {
        return String.valueOf(price);
    }
}
