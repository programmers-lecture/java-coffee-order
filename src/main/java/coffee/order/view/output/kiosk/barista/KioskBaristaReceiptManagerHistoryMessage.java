package coffee.order.view.output.kiosk.barista;

import coffee.order.dto.receipt.ReceiptsDto;
import coffee.order.view.output.OutputView;

public class KioskBaristaReceiptManagerHistoryMessage {

    private final ReceiptsDto kioskReceiptsDto;

    public KioskBaristaReceiptManagerHistoryMessage(ReceiptsDto kioskReceiptsDto) {
        this.kioskReceiptsDto = kioskReceiptsDto;
    }

    public void printReceiptsText() {
        OutputView.print(kioskReceiptsDto.receiptsText());
    }
}
