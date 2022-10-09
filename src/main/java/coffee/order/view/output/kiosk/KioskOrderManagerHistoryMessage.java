package coffee.order.view.output.kiosk;

import coffee.order.domain.food.FoodCategory;

import java.util.Arrays;

import static coffee.order.view.output.OutputView.print;
import static coffee.order.view.output.kiosk.KioskOrderManagerMessage.KIOSK_ORDER_AFTER_ORDER;
import static coffee.order.view.output.kiosk.KioskOrderManagerMessage.KIOSK_ORDER_INPUT_USER_SELECT;

public class KioskOrderManagerHistoryMessage {

    public KioskOrderManagerHistoryMessage() {
    }

    public void printAsksCustomerToSelectMenu() {
        print(KIOSK_ORDER_INPUT_USER_SELECT.message);
    }

    public void printShowMenuToCustomer() {
        print(createMenu());
    }

    public void printAfterSelectMenu() {
        print(KIOSK_ORDER_AFTER_ORDER.message);
    }

    private String createMenu() {
        StringBuilder menuBuilder = new StringBuilder();
        Arrays.stream(FoodCategory.values())
                .forEach(category -> menuBuilder.append(category.toFoodCategoryDto().toString()).append("\n\n"));
        return menuBuilder.toString();
    }

}
