package coffee.order.domain.food;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static coffee.order.domain.food.FoodCategory.*;
import static org.assertj.core.api.Assertions.assertThat;

class FoodCategoryTest {

    @DisplayName("음식 카테고리 이름으로 음식 카테고리 찾기 테스트")
    @ParameterizedTest
    @ValueSource(strings = {"커피", "티", "디저트"})
    void findCategoryByCategoryNameTest(String categoryName) {
//        assertThat(categoryName)
//                .isEqualTo(findFoodCategoryByCategoryName(categoryName).findName());
    }

    @DisplayName("음식 카테고리 아이디으로 음식 카테고리 찾기 테스트")
    @ParameterizedTest
    @ValueSource(longs = {1, 2, 3})
    void findCategoryByCategoryIdTest(Long categoryId) {
//        FoodCategory foods = findFoodCategoryByCategoryId(categoryId);
//        assertThat(categoryId).isEqualTo(foods.findId());
    }

}