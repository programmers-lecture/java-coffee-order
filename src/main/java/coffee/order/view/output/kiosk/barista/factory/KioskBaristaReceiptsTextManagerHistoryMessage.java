package coffee.order.view.output.kiosk.barista.factory;

import coffee.order.dto.kiosk.receipt.KioskReceiptsDto;

import static coffee.order.view.output.OutputView.print;

public class KioskBaristaReceiptsTextManagerHistoryMessage {

    private final KioskReceiptsDto kioskReceiptsDto;

    public KioskBaristaReceiptsTextManagerHistoryMessage(KioskReceiptsDto kioskReceiptsDto) {
        this.kioskReceiptsDto = kioskReceiptsDto;
    }

    public void printReceiptsText() {
        print(kioskReceiptsDto.receiptsText());
    }
}
