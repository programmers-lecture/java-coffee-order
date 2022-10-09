package coffee.order.view.input.controller;

import static coffee.order.util.RegexUtil.REGEX_CUSTOMER_OR_BARISTA_FORM_VALIDATOR;
import static coffee.order.util.RegexUtil.checkFormValid;
import static coffee.order.view.input.InputView.read;
import static coffee.order.view.input.exception.CafeControllerInputException.NO_SUCH_CHARACTER_EXCEPTION;

public class CafeControllerInput {

    public String askCustomerOrBarista() {
        String chosenOne = read();
        if (checkCharacterChooseFormNotOk(chosenOne)) {
            throw new NullPointerException(NO_SUCH_CHARACTER_EXCEPTION.message);
        }
        return chosenOne;
    }

    private boolean checkCharacterChooseFormNotOk(String chosenOne) {
        return chosenOne.length() == 0 ||
                !checkFormValid(REGEX_CUSTOMER_OR_BARISTA_FORM_VALIDATOR, chosenOne);
    }
}
