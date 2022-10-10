package coffee.order.dto.kiosk.receipt;

import coffee.order.dto.receipt.ReceiptsDto;

import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

import static coffee.order.view.output.UnitMessage.ENTER;

public class KioskReceiptsDto {

    private final Map<String, ReceiptsDto> receiptsDto;

    public KioskReceiptsDto(Map<String, ReceiptsDto> receiptsDto) {
        this.receiptsDto = receiptsDto;
    }

    public String receiptsText() {
        AtomicInteger id = new AtomicInteger(1);
        StringBuilder receiptsTextBuilder = new StringBuilder();
        receiptsDto.values()
                .forEach(receiptsDto -> receiptsTextBuilder
                        .append(receiptsDto.receiptsText(id)));
        receiptsTextBuilder.append(ENTER.unit);
        return receiptsTextBuilder.toString();
    }

}
