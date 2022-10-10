package coffee.order.dto.kiosk.receipt;

import coffee.order.dto.receipt.ReceiptDto;

import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

import static coffee.order.view.output.UnitMessage.*;

public class ReceiptsDto {

    private final Map<String, ReceiptDto> receipts;

    public ReceiptsDto(Map<String, ReceiptDto> receipts) {
        this.receipts = receipts;
    }

    public String receiptsText() {
        AtomicInteger id = new AtomicInteger(1);
        StringBuilder receiptsTextBuilder = new StringBuilder();
        receipts.values()
                .forEach(receiptDto -> receiptsTextBuilder
                        .append(id.getAndIncrement())
                        .append(DOT.unit)
                        .append(SPACE.unit)
                        .append(receiptDto.receiptText())
                        .append(ENTER.unit));
        return receiptsTextBuilder.toString();
    }

}
