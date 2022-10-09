package coffee.order.dto.kiosk.receipt;

import java.util.Map;

import static coffee.order.view.output.UnitMessage.*;

public class KioskReceiptsDto {

    private final Map<String, KioskReceiptDto> receipts;

    public KioskReceiptsDto(Map<String, KioskReceiptDto> receipts) {
        this.receipts = receipts;
    }

    public String receiptsText() {
        int id = 1;
        StringBuilder receiptsTextBuilder = new StringBuilder();
        receipts.values()
                .forEach(receiptDto -> receiptsTextBuilder
                        .append(id)
                        .append(DOT.unit)
                        .append(SPACE.unit)
                        .append(receiptDto.receiptText())
                        .append(ENTER.unit));
        return receiptsTextBuilder.toString();
    }

}
