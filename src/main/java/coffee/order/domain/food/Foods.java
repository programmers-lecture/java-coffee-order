package coffee.order.domain.food;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static coffee.order.exception.FoodsException.FOODS_GET_NULL_POINTER_EXCEPTION;

public enum Foods {

    COFFEE(new ArrayList<>(), "커피", 1),
    TEA(new ArrayList<>(), "티", 2),
    DESSERT(new ArrayList<>(), "디저트", 3);

    private List<Food> typeFoods;
    private final String foodTypeName;
    private final Integer foodTypeId;

    Foods(List<Food> typeFoods, String foodTypeName, Integer foodTypeId) {
        this.typeFoods = typeFoods;
        this.foodTypeName = foodTypeName;
        this.foodTypeId = foodTypeId;
    }
    
    public List<Food> findTypeFoodsByName(String foodsTypeName) {
        return findFoodsByName(foodsTypeName).typeFoods;
    }

    public List<Food> findTypeFoodsByTypeId(int foodTypeId) {
        return findFoodsByTypeId(foodTypeId).typeFoods;
    }

    private Foods findFoodsByName(String foodsTypeName) {
        return Arrays.stream(Foods.values())
                .dropWhile(typeFoods -> checkSameFoodTypeName(foodsTypeName, typeFoods))
                .findFirst()
                .orElseThrow(FOODS_GET_NULL_POINTER_EXCEPTION::throwMyException);
    }

    private Foods findFoodsByTypeId(int foodTypeId) {
        return Arrays.stream(Foods.values())
                .dropWhile(typeFoods -> checkSameFoodTypeId(foodTypeId, typeFoods))
                .findFirst()
                .orElseThrow(FOODS_GET_NULL_POINTER_EXCEPTION::throwMyException);
    }

    private boolean checkSameFoodTypeName(String foodsTypeName, Foods typeFoods) {
        return typeFoods.foodTypeName.equals(foodsTypeName);
    }

    private boolean checkSameFoodTypeId(int foodsTypeName, Foods typeFoods) {
        return typeFoods.foodTypeId == foodsTypeName;
    }

}
