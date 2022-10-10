package coffee.order.dto.receipt;

import java.util.Map;

import static coffee.order.view.output.UnitMessage.*;

public class ReceiptsDto {

    private final Map<String, ReceiptDto> receipts;

    public ReceiptsDto(Map<String, ReceiptDto> receipts) {
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
