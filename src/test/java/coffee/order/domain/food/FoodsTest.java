package coffee.order.domain.food;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static coffee.order.domain.food.FoodCategory.findFoodsByCategoryId;
import static coffee.order.exception.FoodException.FOODS_GET_NULL_POINTER_EXCEPTION;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatNullPointerException;

class FoodsTest {

    @ParameterizedTest(name = "[{index}] : 카테고리 번호 = {0}, 음식 번호 = {1}, 음식 이름 = {2}")
    @MethodSource("getMenusWhenFindFoodThenSuccess")
    @DisplayName("음식 카테고리, 음식 번호를 이용한 음식 검색 성공 테스트")
    void whenFindFoodByCategoryIdAndFoodIdThenSuccessTest(Long categoryId, Long foodId, String foodName) {
        Food findFood = findFoodsByCategoryId(categoryId)
                .findFoodByFoodId(foodId);

        assertThat(findFood.toFoodNameString()).isEqualTo(foodName);
    }

    static Stream<Arguments> getMenusWhenFindFoodThenSuccess() {
        return Stream.of(
                Arguments.arguments(1L, 1L, "에스프레소"),
                Arguments.arguments(1L, 2L, "아메리카노"),
                Arguments.arguments(2L, 1L, "그린티"),
                Arguments.arguments(3L, 1L, "케익")
        );
    }

    @ParameterizedTest(name = "[{index}] 카테고리 번호 = {0}, 음식 번호 = {1}")
    @MethodSource("getFoodIdWhenFindByNotEnrolledFoodIdThenThrowException")
    @DisplayName("등록되지 않은 음식 번호를 이용한 음식 검색 예외 처리 테스트")
    void whenFindByNotEnrolledFoodIdThenThrowExceptionTest(Long categoryId, Long foodId) {
        Foods findFoodCategory = findFoodsByCategoryId(categoryId);

        assertThatNullPointerException()
                .isThrownBy(() -> findFoodCategory.findFoodByFoodId(foodId))
                .withMessage(FOODS_GET_NULL_POINTER_EXCEPTION.getMessage());
    }

    static Stream<Arguments> getFoodIdWhenFindByNotEnrolledFoodIdThenThrowException() {
        return Stream.of(
                Arguments.arguments(1L, -1L),
                Arguments.arguments(1L, -2L),
                Arguments.arguments(1L, -3L),
                Arguments.arguments(1L, -4L),
                Arguments.arguments(1L, -5L),
                Arguments.arguments(2L, -1L),
                Arguments.arguments(2L, -2L),
                Arguments.arguments(2L, -3L),
                Arguments.arguments(2L, -4L),
                Arguments.arguments(2L, -5L),
                Arguments.arguments(3L, -1L),
                Arguments.arguments(3L, -2L),
                Arguments.arguments(3L, -3L),
                Arguments.arguments(3L, -4L),
                Arguments.arguments(3L, -5L),
                Arguments.arguments(1L, Long.MAX_VALUE),
                Arguments.arguments(1L, Long.MIN_VALUE)
        );
    }
}