package coffee.order.view.output.kiosk.barista.factory;

import coffee.order.dto.customer.CustomersDto;

import static coffee.order.view.output.OutputView.print;

public class KioskBaristaCustomersCouponTextManagerHistoryMessage {

    private final CustomersDto customersDto;

    public KioskBaristaCustomersCouponTextManagerHistoryMessage(CustomersDto customersDto) {
        this.customersDto = customersDto;
    }

    public void printCustomersCouponText() {
        print(customersDto.customersCouponUsedText());
    }
}
