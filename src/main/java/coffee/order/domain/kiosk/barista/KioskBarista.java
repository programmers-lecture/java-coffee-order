package coffee.order.domain.kiosk.barista;

import coffee.order.domain.kiosk.barista.factory.KioskBaristaProcessFactory;
import coffee.order.view.input.kiosk.barista.KioskBaristaInput;
import coffee.order.view.output.kiosk.barista.KioskBaristaHistoryMessage;

public class KioskBarista {

    public KioskBaristaHistoryMessage baristaHistory() {
        return new KioskBaristaHistoryMessage();
    }

    public KioskBaristaInput baristaInput() {
        return new KioskBaristaInput();
    }

    public void process() {
        baristaHistory().printBaristaToSelectMenu();
        baristaHistory().printBaristaMenus();
        String menu = baristaInput().askBaristaSelectMenu();

        KioskBaristaProcessFactory.find(menu)
                                  .process();
    }
}
