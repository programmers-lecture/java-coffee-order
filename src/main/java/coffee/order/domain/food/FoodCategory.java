package coffee.order.domain.food;

import java.util.*;

import static coffee.order.exception.FoodCategoryException.FOODS_GET_NULL_POINTER_EXCEPTION;

public enum FoodCategory {

    COFFEE(new ArrayList<>(), "커피", 1L),
    TEA(new ArrayList<>(), "티", 2L),
    DESSERT(new ArrayList<>(), "디저트", 3L);

    private List<Food> foods;
    private final String name;
    private final Long id;

    FoodCategory(List<Food> category, String name, Long id) {
        this.foods = category;
        this.name = name;
        this.id = id;
    }

    public static List<Food> findTypeFoodsByCategoryName(String categoryName) {
        return findFoodsByCategoryName(categoryName).foods;
    }

    public static List<Food> findTypeFoodsByCategoryId(Long categoryId) {
        return findFoodsByCategoryId(categoryId).foods;
    }

    public static FoodCategory findFoodsByCategoryName(String categoryName) {
        return findOptionalFoodsByCategoryName(categoryName)
                .orElseThrow(FOODS_GET_NULL_POINTER_EXCEPTION::throwMyException);
    }

    public static FoodCategory findFoodsByCategoryId(Long categoryId) {
        return findOptionalFoodsByCategoryId(categoryId)
                .orElseThrow(FOODS_GET_NULL_POINTER_EXCEPTION::throwMyException);
    }

    private static Optional<FoodCategory> findOptionalFoodsByCategoryName(String categoryName) {
        return Arrays.stream(FoodCategory.values())
                .filter(category -> checkSameFoodTypeName(categoryName, category))
                .findFirst();
    }

    private static Optional<FoodCategory> findOptionalFoodsByCategoryId(Long categoryId) {
        return Arrays.stream(FoodCategory.values())
                .filter(category -> checkSameFoodTypeId(categoryId, category))
                .findFirst();
    }

    private static boolean checkSameFoodTypeName(String foodsTypeName, FoodCategory category) {
        return category.name.equals(foodsTypeName);
    }

    private static boolean checkSameFoodTypeId(Long categoryId, FoodCategory category) {
        return Objects.equals(category.id, categoryId);
    }

    public String findName() {
        return this.name;
    }

    public Long findId() {
        return this.id;
    }

}
