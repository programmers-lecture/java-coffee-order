package coffee.order.domain.kiosk;

import coffee.order.domain.customer.Customer;
import coffee.order.domain.order.Order;
import coffee.order.domain.order.Orders;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.io.ByteArrayInputStream;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static java.nio.charset.StandardCharsets.UTF_8;
import static org.assertj.core.api.Assertions.assertThat;

class KioskOrderTest {

    private final Customer customer = new Customer();
    private final KioskOrderManager kioskOrder = new KioskOrderManager(customer);
    private static final String ENTER_KEY = "\n";

    @ParameterizedTest(name = "[{index}] 회원 주문 입력 = {0}, 실제 주문 목록 = {1}")
    @MethodSource("getCustomerOrdersWhenCommandThenSuccess")
    @DisplayName("회원 주문 입력, 주문 목록 결과 성공 테스트")
    void whenAskOrdersThenSuccessTest(String customerOrders, List<String> foodNames) {
        System.setIn(new ByteArrayInputStream(customerOrders.getBytes(UTF_8)));

        Orders orders = kioskOrder.processOrder();

        List<String> collect =
                orders.getOrders()
                        .stream()
                        .map(Order::getFoodName)
                        .collect(Collectors.toUnmodifiableList());

        assertThat(collect).isSubsetOf(foodNames);
    }

    static Stream<Arguments> getCustomerOrdersWhenCommandThenSuccess() {
        return Stream.of(
                Arguments.arguments("1-1, 1" + ENTER_KEY + "1-2, 1" + ENTER_KEY + ENTER_KEY, List.of("에스프레소", "아메리카노"))
        );
    }

}