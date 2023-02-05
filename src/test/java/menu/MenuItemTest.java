package menu;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.assertj.core.api.Assertions.assertThat;

class MenuItemTest {
    @DisplayName("개수에 따른 총 가격 계산 테스트")
    @Test
    void calculateTotalPrice() {
        MenuItem menuItem1 = new MenuItem(MenuCategory.COFFEE,
                1,
                "에스프레소",
                BigDecimal.valueOf(1000.0));

        assertThat(menuItem1.calculateOrderPrice(3)).isEqualTo(BigDecimal.valueOf(3000.0));
        assertThat(menuItem1.calculateOrderPrice(4)).isEqualTo(BigDecimal.valueOf(4000.0));
        assertThat(menuItem1.calculateOrderPrice(5)).isEqualTo(BigDecimal.valueOf(5000.0));
    }
}