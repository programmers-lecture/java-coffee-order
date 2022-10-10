package coffee.order.domain.kiosk;

import coffee.order.domain.kiosk.barista.KioskBarista;
import coffee.order.domain.kiosk.customer.KioskCustomer;
import coffee.order.domain.kiosk.setting.KioskSetting;

public class KioskManager {

    private final KioskSetting kioskSetting;

    public KioskManager() {
        this.kioskSetting = new KioskSetting();
    }

    public void processCustomer() {
        KioskCustomer kioskCustomer = new KioskCustomer(this);
        kioskCustomer.processOrder();
        kioskCustomer.processCoupon();
        kioskCustomer.giveReceipt();

        kioskCustomer.reflectOrders(kioskSetting);
        kioskCustomer.reflectReceipt(kioskSetting);
//        kioskCustomer.reflectCustomer(kioskSetting);
    }

    public void processBarista() {
        KioskBarista kioskBarista = new KioskBarista();
        kioskBarista.process();
    }
}
