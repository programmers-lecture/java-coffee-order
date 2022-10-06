package coffee.order.view.input.pos;

import static coffee.order.view.input.InputView.read;

public class KioskOrderInput {

    public String askCustomerToChooseFood() {
        return read();
    }
}
