package coffee.order.domain.food;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static coffee.order.exception.FoodException.FOOD_CATEGORY_GET_NULL_POINTER_EXCEPTION;

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

    public static Foods findFoodsByCategoryId(Long categoryId) {
        return Arrays.stream(FoodCategory.values())
                .filter(category -> checkSameFoodCategoryId(categoryId, category.id))
                .map(category -> category.foods)
                .findFirst()
                .orElseThrow();
    }

    private static boolean checkSameFoodCategoryId(Long findCategoryId, Long categoryId) {
        return categoryId.longValue() == findCategoryId.longValue();
    }

    /**
     * view
     * 변경할 시에 -> 도메인에서 수정 ? -> 여기 역할이 아니다.
     */
    public static String getMenuMessage() {
        StringBuilder menuBuilder = new StringBuilder();
        Arrays.stream(FoodCategory.values())
                .forEach(category -> {
                    category.toFoodCategoryStringBuilder(menuBuilder);
                    category.foods.toFoodsMenuStringBuilder(menuBuilder, category.id);
                    menuBuilder.append("\n\n");
                });
        return menuBuilder.toString();
    }

    public void toFoodCategoryStringBuilder(StringBuilder categoryMenu) {
        categoryMenu
                .append(this.id)
                .append(".")
                .append(" ")
                .append(this.name)
                .append("\n");
    }
}
