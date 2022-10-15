package coffee.order.domain.food;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.LongStream;
import java.util.stream.Stream;

import static coffee.order.domain.food.FoodCategory.findFoodsByCategoryId;
import static coffee.order.exception.FoodException.FOOD_CATEGORY_GET_NULL_POINTER_EXCEPTION;
import static org.assertj.core.api.Assertions.assertThatNullPointerException;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

class FoodCategoryTest {

    @ParameterizedTest(name = "[{index}] 카테고리 번호 = {0}")
    @MethodSource("getCategoryIdWhenFindThenSuccess")
    @DisplayName("카테고리 번호를 이용한 음식 검색 성공 테스트")
    void whenFindFoodCategoryByCategoryIdThenSuccessTest(Long categoryId) {
        Foods findFoods = findFoodsByCategoryId(categoryId);
        assertThat(findFoods).isNotNull();
    }

    static Stream<Arguments> getCategoryIdWhenFindThenSuccess() {
        return LongStream.rangeClosed(1, FoodCategory.values().length)
                .mapToObj(FoodCategoryTest::createArgumentByCategoryId);
    }

    static Arguments createArgumentByCategoryId(Long categoryId) {
        return Arguments.arguments(categoryId);
    }

    @ParameterizedTest(name = "[{index}] 카테고리 번호 = {0}")
    @MethodSource("getCategoryIdWhenFindByNotEnrolledCategoryIdThenThrowException")
    @DisplayName("등록되지 않은 음식 카테고리 번호를 이용한 음식 검색 예외 처리 테스트")
    void whenFindByNotEnrolledCategoryIdThenThrowExceptionTest(Long categoryId) {
        assertThatNullPointerException()
                .isThrownBy(() -> findFoodsByCategoryId(categoryId))
                .withMessage(FOOD_CATEGORY_GET_NULL_POINTER_EXCEPTION.getMessage());
    }

    static Stream<Arguments> getCategoryIdWhenFindByNotEnrolledCategoryIdThenThrowException() {
        return Stream.of(
                Arguments.arguments(-1L),
                Arguments.arguments(-2L),
                Arguments.arguments(-3L),
                Arguments.arguments(-4L),
                Arguments.arguments(-5L),
                Arguments.arguments(Long.MAX_VALUE),
                Arguments.arguments(Long.MIN_VALUE)
        );
    }

}