package coffee.order.domain.food;

import java.util.List;
import java.util.Optional;
import java.util.function.Predicate;

import static coffee.order.exception.FoodException.FOODS_GET_NULL_POINTER_EXCEPTION;

public class Foods {

    private List<Food> foods;

    public Foods() {
        this.foods = List.of(
                new Food(1L, "아메리카노", 10000, 10),
                new Food(2L, "아아2", 10000, 10),
                new Food(3L, "아아3", 10000, 10)
        );
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
