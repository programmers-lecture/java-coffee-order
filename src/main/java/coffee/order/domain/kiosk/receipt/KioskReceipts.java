package coffee.order.domain.kiosk.receipt;

import coffee.order.domain.customer.Phone;
import coffee.order.domain.receipt.Receipt;
import coffee.order.domain.receipt.Receipts;
import coffee.order.dto.kiosk.receipt.KioskReceiptsDto;
import coffee.order.dto.receipt.ReceiptsDto;

import java.util.HashMap;
import java.util.Map;

public enum KioskReceipts {

    RECEIPTS(new HashMap<>());

    private final Map<String, Receipts> receipts;

    KioskReceipts(Map<String, Receipts> receipts) {
        this.receipts = receipts;
    }

    public KioskReceiptsDto toKioskReceiptsDto() {
        Map<String, ReceiptsDto> receiptsDto = new HashMap<>();
        receipts.forEach((key, value) -> receiptsDto.put(key, value.toReceiptsDto()));
        return new KioskReceiptsDto(receiptsDto);
    }

    public void saveReceipt(Phone phone, Receipt receipt) {
        String phoneNumber = phone.loadPhoneNumber();
        if (!receipts.containsKey(phoneNumber)) {
            receipts.put(phoneNumber, new Receipts());
        }
        receipts.get(phoneNumber)
                .addReceipts(receipt);
    }
}
