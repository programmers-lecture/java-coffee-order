package coffee.order.domain.food;

import coffee.order.dto.food.FoodDto;

import java.util.Objects;

public class Food {

    private final Long id;
    private final Long categoryId;
    private final FoodName name;
    private final FoodPrice price;
    private final FoodQuantity quantity;

    public Food(Long id, Long categoryId, String name, int price, int quantity) {
        this.id = id;
        this.categoryId = categoryId;
        this.name = new FoodName(name);
        this.price = new FoodPrice(price);
        this.quantity = new FoodQuantity(quantity);
    }

    public FoodDto toFoodDto() {
        return new FoodDto(
                id,
                categoryId,
                name.toFoodNameDto(),
                price.toFoodPriceDto()
        );
    }

    public String toFoodNameString() {
        return name.getName();
    }

    public int getPrice() {
        return price.getPrice();
    }

    public void decreaseQuantity(int inputQuantity) {
        this.quantity.decreaseQuantity(inputQuantity);
    }

    boolean checkSameId(Long foodId) {
        return Objects.equals(this.id, foodId);
    }

    private void increaseQuantity(int inputQuantity) {
        this.quantity.increaseQuantity(inputQuantity);
    }

    private void decreasePrice(int inputPrice) {
        this.price.decreasePrice(inputPrice);
    }

    private void increasePrice(int inputPrice) {
        this.price.increasePrice(inputPrice);
    }

}
