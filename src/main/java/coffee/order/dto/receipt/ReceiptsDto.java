package coffee.order.dto.receipt;

import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

import static coffee.order.view.output.UnitMessage.SLASH;

public class ReceiptsDto {

    private final List<ReceiptDto> receiptsDto;

    public ReceiptsDto(List<ReceiptDto> receiptsDto) {
        this.receiptsDto = receiptsDto;
    }

    public String receiptsText(AtomicInteger id) {
        StringBuilder textBuilder = new StringBuilder();
        receiptsDto.forEach(receiptDto -> textBuilder.append(receiptDto.receiptText(id)));
        removeLastSlash(textBuilder);
        return textBuilder.toString();
    }

    private void removeLastSlash(StringBuilder textBuilder) {
        int lastSlashIndex = textBuilder.lastIndexOf(SLASH.unit);
        textBuilder.replace(lastSlashIndex, lastSlashIndex + 1, "");
    }
}
