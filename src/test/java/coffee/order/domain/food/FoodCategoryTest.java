package coffee.order.domain.food;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;

class FoodCategoryTest {

    @DisplayName("카테고리 번호, 음식 번호로 음식 검색 테스트")
    @ParameterizedTest
    @CsvSource({
            "1, 1, 에스프레소",
            "1, 2, 아메리카노",
            "2, 1, 그린티"
    })
    void findFoodsByCategoryId(Long categoryId, Long foodId, String name) {
        assertThat(FoodCategory.findFoodsByCategoryId(categoryId)
                                .findFoodByFoodId(foodId)
                                .toFoodNameString()
        ).isEqualTo(name);
    }

}