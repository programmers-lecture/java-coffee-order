package coffee.order.domain.food;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static coffee.order.exception.FoodException.FOOD_CATEGORY_GET_NULL_POINTER_EXCEPTION;
import static coffee.order.message.MessageUnit.WON;

public enum FoodCategory {

    COFFEE(
            new Foods(List.of(
                    new Food(1L, "에스프레소", 2000, 999),
                    new Food(2L, "아메리카노", 3000, 999),
                    new Food(3L, "콜드블루", 4000, 999),
                    new Food(4L, "카페라떼", 4000, 999)
            )),
            "커피",
            1L
    ),
    TEA(
            new Foods(List.of(
                    new Food(1L, "그린티", 3000, 999)
            )),
            "티",
            2L
    ),
    DESSERT(
            new Foods(List.of(
                    new Food(1L, "케익", 6000, 999)
            )),
            "디저트",
            3L
    );

    private Foods foods;
    private final String name;
    private final Long id;

    FoodCategory(Foods foods, String name, Long id) {
        this.foods = foods;
        this.name = name;
        this.id = id;
    }

    public static Foods findFoodsByFood(Food food) {
        return Arrays.stream(FoodCategory.values())
                .filter(foodCategory -> checkFoodInFoods(food, foodCategory))
                .findFirst()
                .orElseThrow(FOOD_CATEGORY_GET_NULL_POINTER_EXCEPTION::throwMyException)
                .foods;
    }

    private static boolean checkFoodInFoods(Food food, FoodCategory foodCategory) {
        return foodCategory.foods.checkFoodInFoods(food);
    }

    public static Foods findFoodsByCategoryId(Long categoryId) {
        return findFoodCategoryByCategoryId(categoryId).foods;
    }

    public static FoodCategory findFoodCategoryByCategoryName(String categoryName) {
        return findOptionalFoodCategoryByCategoryName(categoryName)
                .orElseThrow(FOOD_CATEGORY_GET_NULL_POINTER_EXCEPTION::throwMyException);
    }

    public static FoodCategory findFoodCategoryByCategoryId(Long categoryId) {
        return findOptionalFoodCategoryByCategoryId(categoryId)
                .orElseThrow(FOOD_CATEGORY_GET_NULL_POINTER_EXCEPTION::throwMyException);
    }

    private static Optional<FoodCategory> findOptionalFoodCategoryByCategoryName(String categoryName) {
        return Arrays.stream(FoodCategory.values())
                .filter(category -> checkSameFoodCategoryName(categoryName, category.name))
                .findFirst();
    }

    private static Optional<FoodCategory> findOptionalFoodCategoryByCategoryId(Long categoryId) {
        return Arrays.stream(FoodCategory.values())
                .filter(category -> checkSameFoodCategoryId(categoryId, category.id))
                .findFirst();

    }

    private static boolean checkSameFoodCategoryName(String foodsTypeName, String categoryName) {
        return categoryName.equals(foodsTypeName);
    }

    private static boolean checkSameFoodCategoryId(Long findCategoryId, Long categoryId) {
        return categoryId.longValue() == findCategoryId.longValue();
    }

//    public String findName() {
//        return this.name;
//    }
//
//    public Long findId() {
//        return this.id;
//    }

    public static String getMenuMessage() {
        StringBuilder menuBuilder = new StringBuilder();
        Arrays.stream(FoodCategory.values())
                .forEach(category -> {
                    menuBuilder
                            .append(category.id)
                            .append(".")
                            .append(" ")
                            .append(category.name)
                            .append("\n");

                    category.foods
                            .getFoods()
                            .forEach(food -> {
                                menuBuilder
                                        .append(category.id)
                                        .append("-")
                                        .append(food.getId())
                                        .append(".")
                                        .append(" ")
                                        .append(food.getName())
                                        .append(" ")
                                        .append("//")
                                        .append(" ")
                                        .append(food.getPrice())
                                        .append(WON.unit)
                                        .append("\n");
                            });

                    menuBuilder.append("\n\n");
                });

        return menuBuilder.toString();
    }
}
