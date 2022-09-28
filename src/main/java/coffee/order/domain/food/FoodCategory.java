package coffee.order.domain.food;

import java.util.Arrays;
import java.util.Optional;

import static coffee.order.exception.FoodException.FOOD_CATEGORY_GET_NULL_POINTER_EXCEPTION;
import static coffee.order.message.MessageUnit.WON;

public enum FoodCategory {

    COFFEE(new Foods(), "커피", 1L),
    TEA(new Foods(), "티", 2L),
    DESSERT(new Foods(), "디저트", 3L);

    private Foods foods;
    private final String name;
    private final Long id;

    FoodCategory(Foods foods, String name, Long id) {
        this.foods = foods;
        this.name = name;
        this.id = id;
    }

    public static Foods findFoodsByCategoryName(String categoryName) {
        return findFoodCategoryByCategoryName(categoryName).foods;
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

    public String findName() {
        return this.name;
    }

    public Long findId() {
        return this.id;
    }

    public static String getMenuMessage() {
        StringBuilder menuBuilder = new StringBuilder();
        Arrays.stream(FoodCategory.values())
                .forEach(category -> { menuBuilder
                            .append(category.id)
                            .append(" ")
                            .append(category.name)
                            .append("\n");

                    category.foods
                            .getFoods()
                            .forEach(food -> { menuBuilder
                                        .append(category.id)
                                        .append("-")
                                        .append(food.getId())
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
