package coffee.order.domain.kiosk.receipt;

import coffee.order.domain.customer.Phone;
import coffee.order.domain.receipt.Receipt;
import coffee.order.dto.kiosk.receipt.ReceiptsDto;
import coffee.order.dto.receipt.ReceiptDto;

import java.util.HashMap;
import java.util.Map;

public enum KioskReceipts {

    RECEIPTS(new HashMap<>());

    private final Map<String, Receipt> receipts;

    KioskReceipts(Map<String, Receipt> receipts) {
        this.receipts = receipts;
    }

    public ReceiptsDto toKioskReceiptsDto() {
        Map<String, ReceiptDto> receiptsDto = new HashMap<>();
        receipts.forEach((key, value) -> receiptsDto.put(key, value.toReceiptDto()));
        return new ReceiptsDto(receiptsDto);
    }

    public void saveReceipt(Phone phone, Receipt receipt) {
        receipts.put(phone.loadPhoneNumber(), receipt);
    }
}
