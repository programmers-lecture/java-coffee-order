package coffee.order.domain.food;

import coffee.order.dto.food.FoodNameDto;

public class FoodName {

    private String name;

    public FoodName(String name) {
        this.name = name;
    }

    public FoodNameDto toFoodNameDto() {
        return new FoodNameDto(name);
    }

}
