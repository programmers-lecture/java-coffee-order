package coffee.order.domain.food;

import java.util.List;
import java.util.Optional;
import java.util.function.Predicate;

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

    public Food findFood(Food findFood) {
        return findOptionalFood(findFood)
                .orElseThrow(FOODS_GET_NULL_POINTER_EXCEPTION::throwMyException);
    }

    public boolean checkFoodInFoods(Food findFood) {
        return findOptionalFood(findFood).isPresent();
    }

    private Optional<Food> findOptionalFood(Food findFood) {
        return foods.stream()
                .filter(food -> food.equals(findFood))
                .findFirst();
    }

    private Optional<Food> findOptionalFoodByFoodId(Long foodId) {
        return foods.stream()
                .filter(checkSameFoodById(foodId))
                .findFirst();
    }

    private Predicate<Food> checkSameFoodById(Long id) {
        return food -> food.getId().longValue() == id.longValue();
    }

//    public List<Food> getFoods() {
//        return foods;
//    }
}
