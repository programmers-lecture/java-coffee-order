package coffee.order.domain.kiosk.barista.factory;

import coffee.order.domain.kiosk.KioskManager;
import coffee.order.view.output.kiosk.barista.factory.KioskBaristaReceiptsTextManagerHistoryMessage;

import static coffee.order.domain.kiosk.receipt.KioskReceipts.RECEIPTS;

public class KioskBaristaReceiptsTextManager implements KioskBaristaProcess {

    KioskBaristaReceiptsTextManagerHistoryMessage receiptHistory() {
        return new KioskBaristaReceiptsTextManagerHistoryMessage(RECEIPTS.toKioskReceiptsDto());
    }

    @Override
    public void process(KioskManager kioskManager) {
        receiptHistory().printReceiptsText();
    }
}
