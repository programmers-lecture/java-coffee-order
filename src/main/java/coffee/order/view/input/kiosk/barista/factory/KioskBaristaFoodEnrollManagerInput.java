package coffee.order.view.input.kiosk.barista.factory;

import coffee.order.domain.kiosk.form.FoodEnrollForm;

import static coffee.order.view.input.InputView.read;
import static coffee.order.view.input.exception.KioskBaristaFoodEnrollManagerInputException.FOOD_ENROLL_FORM_EXCEPTION;

public class KioskBaristaFoodEnrollManagerInput {

    private static final Integer CATEGORY_NAME_FORM_INDEX = 0;
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
                removeCommaAndDot(forms[CATEGORY_NAME_FORM_INDEX]),
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
        return forms[CATEGORY_ID_AND_FOOD_ID_FORM_INDEX].split("-");
    }

    private String removeCommaAndDot(String form) {
        String noComma = form.replace(',', ' ').trim();
        return noComma.replace('.', ' ').trim();
    }

    private String[] splitBySpace(String form) {
        return form.split(" ");
    }

    private boolean checkFoodEnrollForm(String enrollForm) {
        return enrollForm.length() != 0;
    }
}
