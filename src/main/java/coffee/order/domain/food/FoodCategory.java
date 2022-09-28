package coffee.order.domain.food;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static coffee.order.exception.FoodCategoryException.FOODS_GET_NULL_POINTER_EXCEPTION;

public enum FoodCategory {

    COFFEE(new ArrayList<>(), "커피", 1),
    TEA(new ArrayList<>(), "티", 2),
    DESSERT(new ArrayList<>(), "디저트", 3);

    private List<Food> foods;
    private final String name;
    private final Integer id;

    FoodCategory(List<Food> category, String name, Integer id) {
        this.foods = category;
        this.name = name;
        this.id = id;
    }

    public static List<Food> findTypeFoodsByCategoryName(String categoryName) {
        return findFoodsByCategoryName(categoryName).foods;
    }

    public static List<Food> findTypeFoodsByCategoryId(int categoryId) {
        return findFoodsByCategoryId(categoryId).foods;
    }

    public static FoodCategory findFoodsByCategoryName(String categoryName) {
        return findOptionalFoodsByCategoryName(categoryName)
                .orElseThrow(FOODS_GET_NULL_POINTER_EXCEPTION::throwMyException);
    }

    public static FoodCategory findFoodsByCategoryId(int categoryId) {
        return findOptionalFoodsByCategoryId(categoryId)
                .orElseThrow(FOODS_GET_NULL_POINTER_EXCEPTION::throwMyException);
    }

    private static Optional<FoodCategory> findOptionalFoodsByCategoryName(String categoryName) {
        return Arrays.stream(FoodCategory.values())
                .filter(category -> checkSameFoodTypeName(categoryName, category))
                .findFirst();
    }

    private static Optional<FoodCategory> findOptionalFoodsByCategoryId(int categoryId) {
        return Arrays.stream(FoodCategory.values())
                .filter(category -> checkSameFoodTypeId(categoryId, category))
                .findFirst();
    }

    private static boolean checkSameFoodTypeName(String foodsTypeName, FoodCategory category) {
        return category.name.equals(foodsTypeName);
    }

    private static boolean checkSameFoodTypeId(int foodsTypeName, FoodCategory category) {
        return category.id == foodsTypeName;
    }

    public String findName() {
        return this.name;
    }

    public int findId() {
        return this.id;
    }

}
