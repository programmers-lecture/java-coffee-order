package coffee.order.controller;

import coffee.order.domain.*;
import coffee.order.view.InputView;
import coffee.order.view.OutputView;

import java.util.List;

import static coffee.order.domain.Answer.YES;

public class Customer {
    public static final int COUNT_INDEX = 1;
    public static final String NO_VALUE = "";
    private final Kiosk kiosk = new Kiosk();
    private final OutputView outputView = new OutputView();
    private final Cart cart = new Cart();


    public void doOrder() {
        setMenus();
        addMenus();
        printCart();
        useCoupon();
        showReceipt();
    }


    private void setMenus() {
        outputView.printMenu(kiosk.showMenus());
    }

    private void addMenus() {
        while (true) {
            List<String> menuInfo = InputView.inputMenu();
            if (!menuInfo.get(0).equals(NO_VALUE)) {
                addMenu(menuInfo);
            } else if (menuInfo.get(0).equals(NO_VALUE)) {
                break;
            }
        }
    }

    private void useCoupon() {
        outputView.printUseCoupon();
        if (InputView.getLine().equals(YES.getAnswerNumber())) {
            outputView.requestPhoneNumber();
            String phoneNumber = InputView.getLine();
            Coupon.addMenu(phoneNumber, cart.getTotalAmount());
            outputView.printCouponAmount(Coupon.getAmount(phoneNumber));
            useCoupon(phoneNumber);
        }
    }

    private void useCoupon(String phoneNumber) {
        if (cart.isUseCoupon(phoneNumber)) {
            outputView.askUseCoupon();
            if (InputView.getLine().equals(YES.getAnswerNumber())) {
                outputView.printCouponChoiceMenu();
                outputView.printFormat(cart.getMenuList());
                cart.useCoupon(kiosk.getMenu(InputView.getLine()), phoneNumber);
                outputView.printSuccessCouponMSG();
            }
        }
    }

    private void showReceipt() {
        outputView.printOderList();
        outputView.printFormat(cart.getCartInfo());
        outputView.printFinishOrder();
    }


    private void addMenu(List<String> menuInfo) {
        cart.addMenu(kiosk.getMenu(menuInfo.get(0)), getCount(menuInfo));
    }

    private int getCount(List<String> menuInfo) {
        return Integer.parseInt(menuInfo.get(COUNT_INDEX));
    }

    private void printCart() {
        outputView.printOderList();
        outputView.printCartInfo(cart.getCartInfo());
    }
}
