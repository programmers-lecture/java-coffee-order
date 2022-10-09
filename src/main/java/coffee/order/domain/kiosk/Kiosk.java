package coffee.order.domain.kiosk;

import coffee.order.view.input.kiosk.KioskInput;

import static coffee.order.domain.kiosk.KioskCommand.CUSTOMER;

public class Kiosk {

    public KioskInput input() {
        return new KioskInput();
    }

    public void processKiosk(String chosenOne) {
        KioskManager kioskManager = new KioskManager();

//        String chosenOne = input().askCustomerOrBarista();
        if (chosenOne.equals(CUSTOMER.code)) {
            kioskManager.processCustomer();
        }
    }

}
