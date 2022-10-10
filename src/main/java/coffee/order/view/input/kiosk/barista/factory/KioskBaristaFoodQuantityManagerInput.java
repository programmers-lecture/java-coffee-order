package coffee.order.view.input.kiosk.barista.factory;

import coffee.order.view.input.kiosk.barista.form.FoodUpdateForm;

import static coffee.order.util.RegexUtil.REGEX_SELECT_MENU_FORM_VALIDATOR;
import static coffee.order.util.RegexUtil.checkFormValid;
import static coffee.order.view.input.InputView.read;
import static coffee.order.view.input.exception.kiosk.barista.factory.KioskBaristaFoodQuantityManagerInputException.MENU_AND_FOOD_QUANTITY_UPDATE_FORM_EXCEPTION;
import static coffee.order.view.output.UnitMessage.MIDDLE_LINE;
import static coffee.order.view.output.UnitMessage.SPACE;

public class KioskBaristaFoodQuantityManagerInput {

    private static final Integer CATEGORY_ID_AND_FOOD_ID_FORM_INDEX = 0;
    private static final Integer FOOD_QUANTITY_FORM_INDEX = 1;
    private static final Integer CATEGORY_ID_FORM_INDEX = 0;
    private static final Integer FOOD_ID_FORM_INDEX = 0;

    public FoodUpdateForm askMenuAndFoodQuantity() {
        String menuAndFoodQuantity = read();
        if (!checkUpdateForm(menuAndFoodQuantity)) {
            throw new IllegalArgumentException(MENU_AND_FOOD_QUANTITY_UPDATE_FORM_EXCEPTION.message);
        }
        return createFoodQuantityUpdateForm(menuAndFoodQuantity);
    }

    private FoodUpdateForm createFoodQuantityUpdateForm(String form) {
        String[] forms = splitBySpace(form);
        String[] categoryIdAndFoodId = splitCategoryIdAndFoodId(forms);

        return new FoodUpdateForm(
                Long.parseLong(
                        categoryIdAndFoodId[CATEGORY_ID_FORM_INDEX]
                ),
                Long.parseLong(
                        categoryIdAndFoodId[FOOD_ID_FORM_INDEX]
                ),
                Integer.parseInt(
                        forms[FOOD_QUANTITY_FORM_INDEX]
                ),
                0
        );
    }

    private String[] splitCategoryIdAndFoodId(String[] forms) {
        return forms[CATEGORY_ID_AND_FOOD_ID_FORM_INDEX].split(MIDDLE_LINE.unit);
    }

    private String[] splitBySpace(String form) {
        return form.split(SPACE.unit);
    }

    private boolean checkUpdateForm(String menuAndFoodQuantity) {
        return checkFormValid(REGEX_SELECT_MENU_FORM_VALIDATOR, menuAndFoodQuantity);
    }
}
