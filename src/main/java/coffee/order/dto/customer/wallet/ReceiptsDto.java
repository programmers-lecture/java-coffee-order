package coffee.order.dto.customer.wallet;

import coffee.order.dto.order.OrdersDto;

import java.util.List;

public class ReceiptsDto {

    private final List<OrdersDto> receiptsDto;

    public ReceiptsDto(List<OrdersDto> receiptsDto) {
        this.receiptsDto = receiptsDto;
    }

}
