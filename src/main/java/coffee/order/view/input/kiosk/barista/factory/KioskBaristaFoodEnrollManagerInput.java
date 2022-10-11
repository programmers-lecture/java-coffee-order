package coffee.order.view.input.kiosk.barista.factory;

import coffee.order.view.input.kiosk.barista.form.FoodEnrollForm;

import static coffee.order.view.input.InputView.read;
import static coffee.order.view.input.exception.kiosk.barista.factory.KioskBaristaFoodEnrollManagerInputException.FOOD_ENROLL_FORM_EXCEPTION;
import static coffee.order.view.output.UnitMessage.*;

public class KioskBaristaFoodEnrollManagerInput {

    private static final Integer CATEGORY_ID_AND_FOOD_ID_FORM_INDEX = 1;
    private static final Integer FOOD_NAME_FORM_INDEX = 2;
    private static final Integer FOOD_PRICE_FORM_INDEX = 3;
    private static final Integer CATEGORY_ID_FORM_INDEX = 0;
    private static final Integer FOOD_ID_FORM_INDEX = 1;

    public FoodEnrollForm askFoodEnrollForm() {
        String enrollForm = read();
        if (!checkFoodEnrollForm(enrollForm)) {
            throw new IllegalArgumentException(FOOD_ENROLL_FORM_EXCEPTION.message);
        }

        return createFoodEnrollForm(enrollForm);
    }

    private FoodEnrollForm createFoodEnrollForm(String enrollForm) {
        String[] forms = splitBySpace(enrollForm);

        String[] categoryIdAndFoodId = splitCategoryIdAndFoodId(forms);

        return new FoodEnrollForm(
                removeCommaAndDot(forms[FOOD_NAME_FORM_INDEX]),
                Long.parseLong(
                        removeCommaAndDot(categoryIdAndFoodId[CATEGORY_ID_FORM_INDEX])
                ),
                Long.parseLong(
                        removeCommaAndDot(categoryIdAndFoodId[FOOD_ID_FORM_INDEX])
                ),
                Integer.parseInt(
                        removeCommaAndDot(forms[FOOD_PRICE_FORM_INDEX])
                )
        );

    }

    private String[] splitCategoryIdAndFoodId(String[] forms) {
        return forms[CATEGORY_ID_AND_FOOD_ID_FORM_INDEX].split(MIDDLE_LINE.unit);
    }

    private String removeCommaAndDot(String form) {
        String noComma = form.replace(COMMA.unit, SPACE.unit).trim();
        return noComma.replace(DOT.unit, SPACE.unit).trim();
    }

    private String[] splitBySpace(String form) {
        return form.split(SPACE.unit);
    }

    private boolean checkFoodEnrollForm(String enrollForm) {
        return enrollForm.length() != 0;
    }
}
