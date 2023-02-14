package application;

import domain.barista.Barista;
import domain.cafe.Cafe;
import domain.order.Order;
import domain.coupon.Coupon;
import domain.customer.Customer;
import io.input.Input;
import io.output.Output;
import domain.selection.BaristaSelection;
import domain.selection.UserSelection;

public class CafeService {
    public void start() {
        Cafe cafe = new Cafe();
        Barista barista = new Barista(cafe);
        cafe.initMenu();

        while(true) {
            Customer customer = new Customer(barista);
            Output.printUserSelectionRequestMessage();
            UserSelection userSelection = Input.getUserSelection();
            if (userSelection == UserSelection.EXIT) {
                break;
            }
            if (userSelection == UserSelection.CUSTOMER) {
                do {
                    Output.printChoiceMenuRequestMessage();
                    barista.showMenu();
                    customer.addOrder(Input.getOrder(barista.getMenu()));
                } while (customer.wantAdditionalOrder());
                Output.printSuccessfullyOrderedMessage(customer.getOrderList());
                if (customer.wantEarnCoupon()) {
                    Output.printPhoneNumberRequestMessage();
                    Coupon coupon = Input.getCoupon();
                    barista.earnCoupon(coupon);
                    if (barista.canUseCoupon(coupon)) {
                        if (customer.wantUseCoupon()) {
                            Order order = customer.getOrderForApplyCoupon();
                            barista.applyCoupon(coupon, order);
                        }
                    }
                }
                customer.order();
                Output.printSuccessfullyOrderedMessage(customer.getOrderList());
            }
            if (userSelection == UserSelection.BARISTA) {
                Output.printBaristaSelectionRequestMessage();
                BaristaSelection baristaSelection = Input.getBaristaSelection();
                baristaSelection.manage(cafe);
            }
        }
    }
}
