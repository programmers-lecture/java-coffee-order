package coffee.order.domain.kiosk.customer;

import coffee.order.domain.order.Order;
import coffee.order.view.input.kiosk.KioskCouponManagerInput;
import coffee.order.view.output.kiosk.KioskCouponManagerHistoryMessage;

import java.util.Map;
import java.util.Optional;

import static coffee.order.domain.kiosk.KioskCommand.YES;
import static coffee.order.exception.CustomerException.CUSTOMER_NOT_EXIST_ORDER_FOOD_NUMBER;
import static java.lang.String.valueOf;

public class KioskCouponManager {

    private final KioskCustomer kioskCustomer;

    public KioskCouponManager(KioskCustomer kioskCustomer) {
        this.kioskCustomer = kioskCustomer;
    }

    public KioskCouponManagerHistoryMessage kioskCouponHistory() {
        return new KioskCouponManagerHistoryMessage();
    }

    public KioskCouponManagerInput kioskCouponInput() {
        return new KioskCouponManagerInput();
    }

    public void processSaveCoupon(KioskCustomerManager customerManager) {
        if (!askSaveCouponThenCheck()) {
            return;
        }
        String phoneNumber = customerManager.askPhoneNumber();
        customerManager.findCustomerThenSetting(phoneNumber);
        saveCoupon();
    }

    public void processUseCoupon() {
        if (!kioskCustomer.loadCustomer().checkCouponEnough()) {
            return;
        }
        if (!askUseCouponThenCheck()) {
            return;
        }
        kioskCustomer.loadCustomer().useCoupon();
        kioskCustomer.applyCoupon();
    }

    Order findOrderedByCoupon(Map<String, Order> customerOrders) {
        kioskCouponHistory().printKioskToChoose();
        kioskCouponHistory().printToSelectMenuToApplyCoupon(customerOrders);
        String customerSelectedMenu = kioskCouponInput().askCustomerMenuNumberToApplyCoupon();
        return Optional.of(customerOrders)
                .orElseThrow(() -> new NullPointerException(CUSTOMER_NOT_EXIST_ORDER_FOOD_NUMBER.getMessage()))
                .get(customerSelectedMenu);
    }

    private void saveCoupon() {
        kioskCustomer.loadCustomer().saveCoupon();
        int couponQuantity = kioskCustomer.loadCustomer().findCouponQuantity();
        kioskCouponHistory().printCurrentCouponQuantity(valueOf(couponQuantity));
    }

    private boolean askSaveCouponThenCheck() {
        kioskCouponHistory().printWhenAskSaveCoupon();
        kioskCouponHistory().printWhenAskYesOrNo();
        return kioskCouponInput().askCustomerYesOrNo().equals(YES.code);
    }

    private boolean askUseCouponThenCheck() {
        kioskCouponHistory().printWhenAskUseCoupon();
        kioskCouponHistory().printWhenAskYesOrNo();
        return kioskCouponInput().askCustomerYesOrNo().equals(YES.code);
    }

}
