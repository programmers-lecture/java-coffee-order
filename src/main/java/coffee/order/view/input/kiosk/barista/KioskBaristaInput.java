package coffee.order.view.input.kiosk.barista;

import coffee.order.view.input.InputView;

import static coffee.order.domain.kiosk.barista.KioskBaristaMenus.checkMenuExists;
import static coffee.order.view.input.exception.KioskBaristaInputException.KIOSK_BARISTA_INPUT_EXCEPTION;

public class KioskBaristaInput {

    public String askBaristaSelectMenu() {
        String menu = InputView.read();
        if (!checkSelectMenu(menu)) {
            throw new NullPointerException(KIOSK_BARISTA_INPUT_EXCEPTION.message);
        }
        return menu;
    }

    private boolean checkSelectMenu(String menu) {
        return menu.length() != 0 && checkMenuExists(menu);
    }
}
