package coffee.order.view.output.kiosk.barista.factory;

import coffee.order.dto.kiosk.receipt.ReceiptsDto;
import coffee.order.view.output.OutputView;

public class KioskBaristaReceiptsTextManagerHistoryMessage {

    private final ReceiptsDto receiptsDto;

    public KioskBaristaReceiptsTextManagerHistoryMessage(ReceiptsDto receiptsDto) {
        this.receiptsDto = receiptsDto;
    }

    public void printReceiptsText() {
        String receiptsText = receiptsDto.receiptsText();
        OutputView.print(receiptsText);
    }
}
