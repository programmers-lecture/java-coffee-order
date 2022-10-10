package coffee.order.dto.customer;

public class CustomerDto {

    private final PhoneDto phoneDto;
    private final WalletDto walletDto;

    public CustomerDto(PhoneDto phoneDto, WalletDto walletDto) {
        this.phoneDto = phoneDto;
        this.walletDto = walletDto;
    }
}
