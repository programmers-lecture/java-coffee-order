package coffee.order.domain.receipt;

import coffee.order.dto.receipt.ReceiptDto;
import coffee.order.dto.receipt.ReceiptsDto;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Receipts {

    private final List<Receipt> receipts;

    public Receipts() {
        this.receipts = new ArrayList<>();
    }

    public ReceiptsDto toReceiptsDto() {
        List<ReceiptDto> receiptsDto = receipts.stream()
                .map(Receipt::toReceiptDto)
                .collect(Collectors.toUnmodifiableList());
        return new ReceiptsDto(receiptsDto);
    }

    public void addReceipts(Receipt receipt) {
        receipts.add(receipt);
    }
}
