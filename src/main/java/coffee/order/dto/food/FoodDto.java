package coffee.order.dto.food;

import static coffee.order.view.output.UnitMessage.WON;

public class FoodDto {

    private final Long id;
    private final Long categoryId;
    private final FoodNameDto name;
    private final FoodPriceDto price;

    public FoodDto(Long id, Long categoryId, FoodNameDto name, FoodPriceDto price) {
        this.id = id;
        this.categoryId = categoryId;
        this.name = name;
        this.price = price;
    }

    public FoodNameDto getName() {
        return name;
    }

    @Override
    public String toString() {
        return categoryId + "-" + id + ". " + name.toString() + " // " + price.toString() + WON.unit + "\n";
    }
}
