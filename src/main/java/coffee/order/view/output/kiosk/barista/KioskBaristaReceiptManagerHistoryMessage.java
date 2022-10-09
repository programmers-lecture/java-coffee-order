package coffee.order.view.output.kiosk.barista;

import coffee.order.dto.kiosk.receipt.KioskReceiptsDto;
import coffee.order.view.output.OutputView;

public class KioskBaristaReceiptManagerHistoryMessage {

    private final KioskReceiptsDto kioskReceiptsDto;

    public KioskBaristaReceiptManagerHistoryMessage(KioskReceiptsDto kioskReceiptsDto) {
        this.kioskReceiptsDto = kioskReceiptsDto;
    }

    public void printReceiptsText() {
        OutputView.print(kioskReceiptsDto.receiptsText());
    }
}
