package coffee.order.view.output.kiosk.barista;

import coffee.order.domain.kiosk.barista.KioskBaristaMenus;

import java.util.Arrays;

import static coffee.order.view.output.OutputView.print;
import static coffee.order.view.output.UnitMessage.*;
import static coffee.order.view.output.kiosk.barista.KioskBaristaMessage.KIOSK_BARISTA_ASK_SELECT_MENU;

public class KioskBaristaHistoryMessage {

    public void printBaristaToSelectMenu() {
        print(KIOSK_BARISTA_ASK_SELECT_MENU.message + ENTER.unit);
    }

    public void printBaristaMenus() {
        StringBuilder textBuilder = new StringBuilder();
        Arrays.stream(KioskBaristaMenus.values())
                .forEach(menu -> textBuilder
                        .append(menu.menuType)
                        .append(DOT.unit)
                        .append(SPACE.unit)
                        .append(menu.menuName)
                        .append(ENTER.unit)
                );

        textBuilder.append(ENTER.unit);
        print(textBuilder.toString());
    }
}
