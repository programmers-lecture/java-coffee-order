package coffee.order.dto.customer;

import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

import static coffee.order.view.output.UnitMessage.*;

public class CustomersDto {

    private final Map<String, CustomerDto> customersDto;

    public CustomersDto(Map<String, CustomerDto> customersDto) {
        this.customersDto = customersDto;
    }

    public String customersCouponUsedText() {
        AtomicInteger id = new AtomicInteger(1);
        StringBuilder textBuilder = new StringBuilder();
        customersDto.values()
                .forEach(customerDto -> textBuilder
                        .append(id.getAndIncrement())
                        .append(DOT.unit)
                        .append(SPACE.unit)
                        .append(customerDto.couponUsedCountText())
                        .append(ENTER.unit));

        return textBuilder.toString();
    }
}
