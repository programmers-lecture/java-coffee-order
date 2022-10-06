package coffee.order.view.input.controller;

import static coffee.order.domain.pos.KioskCommand.BARISTA;
import static coffee.order.domain.pos.KioskCommand.CUSTOMER;
import static coffee.order.view.input.InputView.read;
import static coffee.order.view.input.exception.CafeControllerInputException.NO_SUCH_CHARACTER_EXCEPTION;

public class CafeControllerInput {

    public String askCustomerOrBarista() {
        String chosenOne = read();
        if (checkCharacterChooseFormNotOk(chosenOne)) {
            throw new NullPointerException(NO_SUCH_CHARACTER_EXCEPTION.message);
        }
        return read();
    }

    private boolean checkCharacterChooseFormNotOk(String chosenOne) {
        return chosenOne.length() == 0 ||
                (!chosenOne.equals(CUSTOMER.selectedCommand) &&
                        !chosenOne.equals(BARISTA.selectedCommand));
    }
}
