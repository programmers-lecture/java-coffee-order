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

    public Food findFoodByFoodId(Long id) {
        return findOptionalFoodByFoodId(id)
                .orElseThrow(FOODS_GET_NULL_POINTER_EXCEPTION::throwMyException);
    }

    private Optional<Food> findOptionalFoodByFoodId(Long id) {
        return foods.stream()
                .filter(checkSameFoodById(id))
                .findFirst();
    }

    private Predicate<Food> checkSameFoodById(Long id) {
        return food -> food.getId().longValue() == id.longValue();
    }

    public List<Food> getFoods() {
        return foods;
    }
}
