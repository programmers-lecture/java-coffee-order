package coffee.order.view;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.HashMap;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

class InputViewTest {
    private final InputView inputView = new InputView();

    @DisplayName("메뉴 선택 -> 거래 포맷 변환 테스트")
    @Test
    void convertToTransactionFormatTest() {
        // given
        final String menuChoice = "1-1, 3";

        // when
        HashMap<String, Integer> transactionFormat = inputView.convertToTransactionFormat(menuChoice);

        // then
        assertThat(transactionFormat.get("1-1")).isEqualTo(3);
    }
}