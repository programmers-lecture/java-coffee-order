package coffee.order.domain.food;

import coffee.order.dto.food.FoodsDto;

import java.util.List;
import java.util.stream.Collectors;

import static coffee.order.exception.FoodException.FOODS_GET_NULL_POINTER_EXCEPTION;

public class Foods {

    private List<Food> foods;

    public Foods(List<Food> foods) {
        this.foods = foods;
    }

    public FoodsDto toFoodsDto() {
        return new FoodsDto(
                foods.stream()
                        .map(Food::toFoodDto)
                        .collect(Collectors.toUnmodifiableList()));
    }

    public Food findFoodByFoodId(Long foodId) {
        return foods.stream()
                .filter(food -> food.checkSameId(foodId))
                .findFirst()
                .orElseThrow(() -> new NullPointerException(FOODS_GET_NULL_POINTER_EXCEPTION.getMessage()));
    }

}
