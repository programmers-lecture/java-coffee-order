package coffee.order.models;

import coffee.order.enums.FoodCategory;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Menu {
    private final List<Food> foods;

    public Menu() {
        foods = new ArrayList<>();
        foods.add(new Food(FoodCategory.COFFEE, "1-1", "에스프레소", 2000));
        foods.add(new Food(FoodCategory.COFFEE, "1-2", "아메리카노", 3000));
        foods.add(new Food(FoodCategory.COFFEE, "1-3", "콜드블루", 4000));
        foods.add(new Food(FoodCategory.COFFEE, "1-4", "카페라떼", 0));
        foods.add(new Food(FoodCategory.TEA, "2-1", "그린티", 0));
        foods.add(new Food(FoodCategory.DESSERT, "3-1", "케잌", 0));
    }

    public List<Food> getFoodsByCategory(FoodCategory category) {
        return foods.stream()
                .filter(food -> food.isFoodCategory(category))
                .collect(Collectors.toList());
    }

    public Food getFoodByNumber(String number) {
        return foods.stream()
                .filter(food -> food.getNumber().equals(number))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("선택한 항목에 해당하는 메뉴가 없습니다."));
    }
}
