package coffee.order.domain.food;

import coffee.order.dto.food.FoodPriceDto;

import static coffee.order.exception.FoodException.PRICE_MINUS_EXCEPTION;

public class FoodPrice {

    private int price;

    public FoodPrice(int price) {
        this.price = price;
    }

    public FoodPriceDto toFoodPriceDto() {
        return new FoodPriceDto(price);
    }

    int getPrice() {
        return price;
    }


    void increasePrice(int inputPrice) {
        this.price += inputPrice;
    }

    void decreasePrice(int inputPrice) {
        if (checkMinusPrice(this.price - inputPrice)) {
            throw new IllegalArgumentException(PRICE_MINUS_EXCEPTION.getMessage());
        }
        this.price -= inputPrice;
    }

    boolean checkMinusPrice(int price) {
        return price < 0;
    }

}
