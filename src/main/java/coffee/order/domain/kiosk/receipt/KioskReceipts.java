package coffee.order.domain.kiosk.receipt;

import coffee.order.dto.kiosk.receipt.KioskReceiptDto;
import coffee.order.dto.kiosk.receipt.KioskReceiptsDto;

import java.util.*;

import static coffee.order.exception.KioskReceiptsException.RECEIPT_NULL_EXCEPTION;

public enum KioskReceipts {

    KIOSK_RECEIPTS(new HashMap<>());

    private final Map<String, KioskReceipt> receipts;

    KioskReceipts(Map<String, KioskReceipt> receipts) {
        this.receipts = receipts;
    }

    public KioskReceiptsDto toKioskReceiptsDto() {
        Map<String, KioskReceiptDto> receiptsDto = new HashMap<>();
        receipts.forEach((key, value) -> receiptsDto.put(key, value.toKioskReceiptDto()));
        return new KioskReceiptsDto(receiptsDto);
    }

    public Collection<KioskReceipt> findAllReceipts() {
        return Optional.of(receipts.values())
                .orElseThrow(() -> new NullPointerException(RECEIPT_NULL_EXCEPTION.message));
    }
}
