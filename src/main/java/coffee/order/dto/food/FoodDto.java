package coffee.order.dto.food;

import static coffee.order.view.output.UnitMessage.WON;

public class FoodDto {

    private final Long id;
    private final Long categoryId;
    private final FoodNameDto name;
    private final FoodPriceDto price;
    private final FoodQuantityDto quantity;

    public FoodDto(Long id, Long categoryId, FoodNameDto name, FoodPriceDto price, FoodQuantityDto quantity) {
        this.id = id;
        this.categoryId = categoryId;
        this.name = name;
        this.price = price;
        this.quantity = quantity;
    }

    @Override
    public String toString() {
        return categoryId + "-" + id + ". " + name.toString() + " // " + price.toString() + WON.unit + "\n";
    }
}
