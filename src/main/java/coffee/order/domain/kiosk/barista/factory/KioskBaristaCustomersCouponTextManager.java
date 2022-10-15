package coffee.order.domain.kiosk.barista.factory;

import coffee.order.domain.kiosk.KioskManager;
import coffee.order.view.output.kiosk.barista.factory.KioskBaristaCustomersCouponTextManagerHistoryMessage;

import static coffee.order.domain.customer.Customers.CUSTOMERS_DATA;

public class KioskBaristaCustomersCouponTextManager implements KioskBaristaProcess {

    public KioskBaristaCustomersCouponTextManagerHistoryMessage customersCouponTextHistory() {
        return new KioskBaristaCustomersCouponTextManagerHistoryMessage(CUSTOMERS_DATA.toCustomersDto());
    }

    @Override
    public void process(KioskManager kioskManager) {
        customersCouponTextHistory().printCustomersCouponText();
    }

}
