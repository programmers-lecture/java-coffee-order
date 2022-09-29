package coffee.order.domain.food;

import java.util.List;
import java.util.Optional;

import static coffee.order.exception.FoodException.FOODS_GET_NULL_POINTER_EXCEPTION;

public class Foods {

    private List<Food> foods;

    public Foods(List<Food> foods) {
        this.foods = foods;
    }

    public Food findFoodByFoodId(Long foodId) {
        return findOptionalFoodByFoodId(foodId)
                .orElseThrow(FOODS_GET_NULL_POINTER_EXCEPTION::throwMyException);
    }

    public void toFoodsMenuStringBuilder(StringBuilder foodsMenu) {
        foods.forEach(food -> food.toFoodMenuStringBuilder(foodsMenu));
    }

    private Optional<Food> findOptionalFoodByFoodId(Long foodId) {
        return foods.stream()
                .filter(food -> food.checkSameId(foodId))
                .findFirst();
    }
}