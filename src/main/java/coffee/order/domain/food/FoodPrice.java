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

    void updatePrice(int inputPrice) {
        if (checkMinusPrice(inputPrice)) {
            throw new IllegalArgumentException(PRICE_MINUS_EXCEPTION.getMessage());
        }
        this.price = inputPrice;
    }

    private boolean checkMinusPrice(int price) {
        return price < 0;
    }

}
