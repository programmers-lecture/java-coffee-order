package coffee.order.domain.customer;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.List;

import static coffee.order.domain.customer.Customers.CUSTOMERS_DATA;
import static coffee.order.exception.CustomerException.CUSTOMER_NO_SUCH_PHONE_NUMBER;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class CustomersTest {

    @BeforeAll()
    static void save_Customer() {
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

    @DisplayName("전화번호로 기존 회원 찾기 테스트")
    @ParameterizedTest
    @ValueSource(strings = {
            "010-0000-0000",
            "010-0000-0001",
            "010-0000-0002",
            "010-0000-0003"
    })
    void find_Customer_By_Phone_Number_Test(String phoneNumber) {
        assertThat(CUSTOMERS_DATA.checkPhoneNumberExists(phoneNumber))
                .isTrue();
    }

    @DisplayName("회원 저장 후 조회 테스트")
    @ParameterizedTest
    @ValueSource(strings = {
            "010-0000-0004",
            "010-0000-0005",
            "010-0000-0006",
            "010-0000-0007"
    })
    void save_Customer_Test(String phoneNumber) {
        Customer customer = new Customer();

        CUSTOMERS_DATA.saveCustomerWithPhoneNumber(
                customer,
                phoneNumber
        );

        assertThat(CUSTOMERS_DATA.findCustomerByPhoneNumber(phoneNumber))
                .isEqualTo(customer);
    }

    @DisplayName("회원 조회 예외 처리 테스트")
    @ParameterizedTest
    @ValueSource(strings = {
            "010-0000-0008",
            "010-0000-0009",
            "010-0000-00010",
            "010-0000-00011"
    })
    void find_Customer_NullPointerException_Test(String phoneNumber) {
        assertThatThrownBy(() -> CUSTOMERS_DATA.findCustomerByPhoneNumber(phoneNumber))
                .isInstanceOf(NullPointerException.class)
                .hasMessage(CUSTOMER_NO_SUCH_PHONE_NUMBER.throwMyException().getMessage());
    }
}