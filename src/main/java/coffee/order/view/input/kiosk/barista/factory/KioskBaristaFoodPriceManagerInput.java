package coffee.order.view.input.kiosk.barista.factory;

import coffee.order.view.input.kiosk.barista.form.FoodUpdateForm;

import static coffee.order.util.RegexUtil.REGEX_SELECT_MENU_FORM_VALIDATOR;
import static coffee.order.util.RegexUtil.checkFormValid;
import static coffee.order.view.input.InputView.read;
import static coffee.order.view.input.exception.kiosk.barista.factory.KioskBaristaFoodPriceManagerInputException.MENU_AND_FOOD_PRICE_UPDATE_FORM_EXCEPTION;
import static coffee.order.view.output.UnitMessage.MIDDLE_LINE;
import static coffee.order.view.output.UnitMessage.SPACE;

public class KioskBaristaFoodPriceManagerInput {

    private static final Integer CATEGORY_ID_AND_FOOD_ID_FORM_INDEX = 0;
    private static final Integer FOOD_PRICE_FORM_INDEX = 1;
    private static final Integer CATEGORY_ID_FORM_INDEX = 0;
    private static final Integer FOOD_ID_FORM_INDEX = 0;

    public FoodUpdateForm askMenuAndFoodPrice() {
        String menuAndFoodPrice = read();
        if (!checkUpdateForm(menuAndFoodPrice)) {
            throw new IllegalArgumentException(MENU_AND_FOOD_PRICE_UPDATE_FORM_EXCEPTION.message);
        }
        return createFoodPriceUpdateForm(menuAndFoodPrice);
    }

    private FoodUpdateForm createFoodPriceUpdateForm(String form) {
        String[] forms = splitBySpace(form);
        String[] categoryIdAndFoodId = splitCategoryIdAndFoodId(forms);

        return new FoodUpdateForm(
                Long.parseLong(
                        categoryIdAndFoodId[CATEGORY_ID_FORM_INDEX]
                ),
                Long.parseLong(
                        categoryIdAndFoodId[FOOD_ID_FORM_INDEX]
                ),
                0,
                Integer.parseInt(
                        forms[FOOD_PRICE_FORM_INDEX]
                )
        );
    }

    private String[] splitCategoryIdAndFoodId(String[] forms) {
        return forms[CATEGORY_ID_AND_FOOD_ID_FORM_INDEX].split(MIDDLE_LINE.unit);
    }

    private String[] splitBySpace(String form) {
        return form.split(SPACE.unit);
    }

    private boolean checkUpdateForm(String menuAndFoodPrice) {
        return checkFormValid(REGEX_SELECT_MENU_FORM_VALIDATOR, menuAndFoodPrice);
    }
}
