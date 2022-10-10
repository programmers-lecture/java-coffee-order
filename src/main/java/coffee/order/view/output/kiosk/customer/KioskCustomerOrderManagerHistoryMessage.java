package coffee.order.view.output.kiosk.customer;

import coffee.order.domain.food.FoodCategory;

import java.util.Arrays;

import static coffee.order.view.output.OutputView.print;
import static coffee.order.view.output.UnitMessage.ENTER;
import static coffee.order.view.output.kiosk.customer.KioskCustomerOrderManagerMessage.KIOSK_ORDER_AFTER_ORDER;
import static coffee.order.view.output.kiosk.customer.KioskCustomerOrderManagerMessage.KIOSK_ORDER_INPUT_USER_SELECT;

public class KioskCustomerOrderManagerHistoryMessage {

    public KioskCustomerOrderManagerHistoryMessage() {
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
                .forEach(category -> menuBuilder.append(category.   toFoodCategoryDto()).append(ENTER.unit).append(ENTER.unit));
        return menuBuilder.toString();
    }

}
