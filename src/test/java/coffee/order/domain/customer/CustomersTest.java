package coffee.order.domain.customer;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;
import java.util.stream.Stream;

import static coffee.order.domain.customer.Customers.CUSTOMERS_DATA;
import static coffee.order.exception.CustomerException.CUSTOMER_NO_SUCH_PHONE_NUMBER;
import static org.assertj.core.api.Assertions.*;

class CustomersTest {

    @BeforeAll()
    static void save_Customer_Test() {
        List<String> phoneNumbers = List.of(
                "010-0000-0000",
                "010-0000-0001",
                "010-0000-0002",
                "010-0000-0003"
        );
        phoneNumbers.forEach(phoneNumber ->
                CUSTOMERS_DATA.saveCustomerWithPhoneNumber(
                        new Customer(),
                        phoneNumber
                )
        );
    }

    @ParameterizedTest(name = "[{index}] 검색한 휴대폰 번호 : {0}")
    @MethodSource("getPhoneNumbersWhenFindCustomersThenSuccess")
    @DisplayName("휴대폰 번호로 기존 회원 검색 성공 테스트")
    void whenFindCustomerByPhoneNumberThenSuccessTest(String phoneNumber) {
        assertThat(CUSTOMERS_DATA.checkPhoneNumberExists(phoneNumber))
                .isTrue();
    }

    static Stream<Arguments> getPhoneNumbersWhenFindCustomersThenSuccess() {
        return Stream.of(
                Arguments.arguments("010-0000-0000"),
                Arguments.arguments("010-0000-0001"),
                Arguments.arguments("010-0000-0002"),
                Arguments.arguments("010-0000-0003")
        );
    }

    @ParameterizedTest(name = "[{index}] 휴대폰 번호 : {0}")
    @MethodSource("getPhoneNumbersToSaveCustomersWhenFindSavedCustomersThenSuccess")
    @DisplayName("휴대폰 번호 이용한 회원 저장 후 조회 성공 테스트")
    void whenCheckSaveCustomersByPhoneNumberThenSuccessTest(String phoneNumber) {
        Customer savedCustomer = new Customer();

        CUSTOMERS_DATA.saveCustomerWithPhoneNumber(savedCustomer, phoneNumber);

        assertThat(CUSTOMERS_DATA.findCustomerByPhoneNumber(phoneNumber))
                .isEqualTo(savedCustomer);
    }

    static Stream<Arguments> getPhoneNumbersToSaveCustomersWhenFindSavedCustomersThenSuccess() {
        return Stream.of(
                Arguments.arguments("010-0000-0004"),
                Arguments.arguments("010-0000-0005"),
                Arguments.arguments("010-0000-0006"),
                Arguments.arguments("010-0000-0007")
        );
    }

    @ParameterizedTest(name = "[{index}] 휴대폰 번호 : {0}")
    @MethodSource("getPhoneNumbersWhenNotEnrolledCustomersThenThrowException")
    @DisplayName("등록되지 않은 휴대폰 번호를 이용한 회원 검색 예외 처리 테스트")
    void whenFindCustomersByNotEnrolledThenThrowExceptionTest(String phoneNumber) {
        assertThatNullPointerException()
                .isThrownBy(() -> CUSTOMERS_DATA.findCustomerByPhoneNumber(phoneNumber))
                .withMessage(CUSTOMER_NO_SUCH_PHONE_NUMBER.getMessage());
    }

    static Stream<Arguments> getPhoneNumbersWhenNotEnrolledCustomersThenThrowException() {
        return Stream.of(
                Arguments.arguments("010-0000-0008"),
                Arguments.arguments("010-0000-0009"),
                Arguments.arguments("010-0000-0010"),
                Arguments.arguments("010-0000-0011")
        );
    }
}