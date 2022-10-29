package coffee.order.dto.food;

public class FoodPriceDto {

    private int price;

    public FoodPriceDto(int price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return String.valueOf(price);
    }
}
