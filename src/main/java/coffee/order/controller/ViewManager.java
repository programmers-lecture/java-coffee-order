package coffee.order.controller;

import coffee.order.model.Menu;
import coffee.order.model.MenuType;
import coffee.order.model.Transaction;
import coffee.order.view.*;

import java.util.ArrayList;
import java.util.HashMap;

public class ViewManager {
    private final InputView inputView;
    private final OutputView outputView;

    public Order readMenuChoice() {
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

    public void confirmOrder(Transaction newTransaction) {
        String orderLiteral = generateOrderLiteral(newTransaction);
        outputView.confirmOrder(orderLiteral);
    }

    private String generateOrderLiteral(Transaction newTransaction) {
        StringBuilder orderLiteral = new StringBuilder();
        orderLiteral.append(newTransaction.getMenuName());
        orderLiteral.append(LiteralCollection.BLANK.getLiteral());
        orderLiteral.append(newTransaction.getOrderQuantity());
        orderLiteral.append(LiteralCollection.COUNT.getLiteral());
        orderLiteral.append(LiteralCollection.BLANK.getLiteral());
        orderLiteral.append(newTransaction.getOrderAmount());
        orderLiteral.append(LiteralCollection.WON.getLiteral());

        return orderLiteral.toString();
    }

    public ConfirmMessage confirmCouponUse() {
        // TODO: 사용 여부 출력 -> 사용 여부 입력 -> 사용 여부 boolean 리턴
        outputView.printCouponConfirmMessage();
        boolean yesOrNot = inputView.readYesOrNot();
        return new ConfirmMessage(yesOrNot);
    }
}
