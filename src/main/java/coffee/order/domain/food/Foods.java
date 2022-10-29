package coffee.order.domain.food;

import coffee.order.dto.food.FoodsDto;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import static coffee.order.exception.FoodException.FOODS_GET_NULL_POINTER_EXCEPTION;
import static coffee.order.exception.FoodException.FOOD_ENROLL_ALREADY_EXISTS_EXCEPTION;

public class Foods {

    private final List<Food> foods;

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

    public void enrollFood(Food food) {
        Food lastFood = foods.get(foods.size() - 1);

        if (!lastFood.checkFoodIdOk(food)) {
            throw new IllegalArgumentException(FOOD_ENROLL_ALREADY_EXISTS_EXCEPTION.getMessage());
        }

        foods.add(food);
    }

}
