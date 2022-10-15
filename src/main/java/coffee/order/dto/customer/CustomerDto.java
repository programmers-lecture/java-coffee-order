package coffee.order.dto.customer;

import coffee.order.dto.customer.wallet.WalletDto;

import static coffee.order.view.output.UnitMessage.*;

public class CustomerDto {

    private final PhoneDto phoneDto;
    private final WalletDto walletDto;

    public CustomerDto(PhoneDto phoneDto, WalletDto walletDto) {
        this.phoneDto = phoneDto;
        this.walletDto = walletDto;
    }

    public String couponUsedCountText() {
        return phoneDto.getPhoneNumber() +
                SPACE.unit
                + MIDDLE_LINE.unit
                + SPACE.unit
                + walletDto.getCouponUsedCount()
                + COUNT.unit;
    }
}
