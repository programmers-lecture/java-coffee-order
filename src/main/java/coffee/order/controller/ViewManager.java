package coffee.order.controller;

import coffee.order.model.Menu;
import coffee.order.model.MenuType;
import coffee.order.model.Order;
import coffee.order.model.Transaction;
import coffee.order.view.InputView;
import coffee.order.view.OutputView;
import coffee.order.view.model.ConfirmMessage;
import coffee.order.view.model.CustomerOrder;
import coffee.order.view.model.LiteralCollection;
import coffee.order.view.model.PhoneNumber;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class ViewManager {
    private final InputView inputView;
    private final OutputView outputView;

    public List<CustomerOrder> readMenuChoice() {
        return inputView.readMenuChoice();
    }

    public ViewManager() {
        inputView = new InputView();
        outputView = new OutputView();
    }

    public void greeting() {
        outputView.printGreetingMessage();
    }

    public void showMenu(MenuType[] menuTypes, HashMap<MenuType, ArrayList<? super Menu>> menu) {
        outputView.printMenu(menuTypes, menu);
    }

    public void confirmOrder(Transaction transaction) {
        List<String> orderLiterals = new ArrayList<>();

        for (Order order : transaction.getOrders()) {
            orderLiterals.add(generateOrderLiteral(order));
        }

        outputView.confirmOrder(orderLiterals);
    }

    private String generateOrderLiteral(Order order) {
        StringBuilder orderLiteral = new StringBuilder();
        orderLiteral.append(order.getMenuName());
        orderLiteral.append(LiteralCollection.BLANK.getLiteral());
        orderLiteral.append(order.getOrderQuantity());
        orderLiteral.append(LiteralCollection.COUNT.getLiteral());
        orderLiteral.append(LiteralCollection.BLANK.getLiteral());
        orderLiteral.append(order.getOrderAmount());
        orderLiteral.append(LiteralCollection.WON.getLiteral());

        return orderLiteral.toString();
    }

    public PhoneNumber readPhoneNumber() {
        outputView.printPhoneNumberGuideMessage();
        String phoneNumber = inputView.readPhoneNumber();
        return new PhoneNumber(phoneNumber);
    }

    public void notifyCouponQuantity(Integer couponQuantity) {
        outputView.printCouponQuatity(couponQuantity);
    }

    public ConfirmMessage confirmCouponAccumulation() {
        outputView.printCouponConfirmMessage();
        return getConfirmMessage();
    }

    public ConfirmMessage confirmCouponApplication() {
        outputView.printCouponApplicationConfirm();
        return getConfirmMessage();
    }

    private ConfirmMessage getConfirmMessage() {
        boolean yesOrNot = inputView.readYesOrNot();
        return new ConfirmMessage(yesOrNot);
    }
}
