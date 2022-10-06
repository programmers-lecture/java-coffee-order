package coffee.order.domain.order;

import coffee.order.domain.customer.Customer;
import coffee.order.domain.food.FoodCategory;
import coffee.order.domain.pos.KioskCommand;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.io.ByteArrayInputStream;
import java.io.FileInputStream;
import java.io.FilterInputStream;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.stream.Stream;

import static coffee.order.domain.food.FoodCategory.*;
import static coffee.order.domain.pos.KioskCommand.*;

class OrdersTest {

    private static final Orders orders = new Orders();

    @BeforeAll()
    static void init() {
        getOrdersWhenInit().forEach(order ->
                orders.addOrder((Order) order)
        );
    }

    static Stream<Arguments> getOrdersWhenInit() {
        return Stream.of(
                Arguments.arguments(new Order(findFoodsByCategoryId(1L).findFoodByFoodId(1L), 10)),
                Arguments.arguments(new Order(findFoodsByCategoryId(1L).findFoodByFoodId(2L), 10)),
                Arguments.arguments(new Order(findFoodsByCategoryId(1L).findFoodByFoodId(3L), 10)),
                Arguments.arguments(new Order(findFoodsByCategoryId(2L).findFoodByFoodId(1L), 10)),
                Arguments.arguments(new Order(findFoodsByCategoryId(3L).findFoodByFoodId(1L), 10))
        );
    }

//    @ParameterizedTest(name = "[{index}] 휴대폰 번호 = {0}")
//    @MethodSource("")
//    @DisplayName("쿠폰으로 구매한 상품, 주문 목록 내 검색 성공 테스트")
//    void whenFindOrderPurchasedByCouponThenSuccess() {
//        Customer customer = new Customer();
//        System.setIn(new ByteArrayInputStream(YES.selectedCommand.getBytes(StandardCharsets.UTF_8)));
//        orders.findOrderPurchasedByCoupon(customer);
//
//
//    }

}