package coffee.order.view.input.kiosk;

import coffee.order.view.input.InputView;

public class KioskInput {

    public String askCustomerOrBarista() {
        return InputView.read();
    }
}
