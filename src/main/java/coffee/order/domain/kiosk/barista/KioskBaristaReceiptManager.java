package coffee.order.domain.kiosk.barista;

import coffee.order.view.output.kiosk.barista.KioskBaristaReceiptManagerHistoryMessage;

import static coffee.order.domain.kiosk.receipt.KioskReceipts.RECEIPTS;

public class KioskBaristaReceiptManager {

    KioskBaristaReceiptManagerHistoryMessage receiptHistory() {
        return new KioskBaristaReceiptManagerHistoryMessage(RECEIPTS.toKioskReceiptsDto());
    }
}
