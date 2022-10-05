package coffee.order.domain.food;

import java.util.Arrays;
import java.util.List;

import static coffee.order.exception.FoodException.FOOD_CATEGORY_GET_NULL_POINTER_EXCEPTION;

public enum FoodCategory {

    COFFEE(
            new Foods(List.of(
                    new Food(1L, 1L, "에스프레소", 2000, 999),
                    new Food(2L, 1L, "아메리카노", 3000, 999),
                    new Food(3L, 1L, "콜드블루", 4000, 999),
                    new Food(4L, 1L, "카페라떼", 4000, 999)
            )),
            "커피",
            1L
    ),
    TEA(
            new Foods(List.of(
                    new Food(1L, 2L, "그린티", 3000, 999)
            )),
            "티",
            2L
    ),
    DESSERT(
            new Foods(List.of(
                    new Food(1L, 3L, "케익", 6000, 999)
            )),
            "디저트",
            3L
    );

    private final Foods foods;
    private final String name;
    private final Long id;

    FoodCategory(Foods foods, String name, Long id) {
        this.foods = foods;
        this.name = name;
        this.id = id;
    }

    public static Foods findFoodsByCategoryId(Long categoryId) {
        return Arrays.stream(FoodCategory.values())
                .filter(category -> checkSameFoodCategoryId(categoryId, category.id))
                .map(category -> category.foods)
                .findFirst()
                .orElseThrow(() -> new NullPointerException(FOOD_CATEGORY_GET_NULL_POINTER_EXCEPTION.getMessage()));
    }

    private static boolean checkSameFoodCategoryId(Long findCategoryId, Long categoryId) {
        return categoryId.longValue() == findCategoryId.longValue();
    }

    @Override
    public String toString() {
        return id + ". " + name + "\n" + foods.toString();
    }
    
}
