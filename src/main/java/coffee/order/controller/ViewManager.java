package coffee.order.controller;

import coffee.order.model.Menu;
import coffee.order.model.MenuType;
import coffee.order.model.Order;
import coffee.order.model.Transaction;
import coffee.order.view.InputView;
import coffee.order.view.OutputView;
import coffee.order.view.model.*;

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

    public PhoneNumber readPhoneNumber() {
        outputView.printPhoneNumberGuideMessage();
        String phoneNumber = inputView.readPhoneNumber();
        return new PhoneNumber(phoneNumber);
    }

    public void notifyCouponQuantity(Integer couponQuantity) {
        outputView.printCouponQuatity(couponQuantity);
    }

    public ConfirmMessage confirmCouponAccumulation() {
        outputView.printCouponAccumulationConfirm();
        return getConfirmMessage();
    }

    public ConfirmMessage confirmCouponUsage() {
        outputView.printCouponUsageConfirm();
        return getConfirmMessage();
    }

    public void confirmOrder(Transaction transaction) {
        List<String> orderLiterals = new ArrayList<>();
        int index = 0;

        for (Order order : transaction.getOrders()) {
            orderLiterals.add(generateOrderLiteral(++index, order));
        }

        outputView.confirmOrder(orderLiterals);
        outputView.printTotalOrderAmount(computeTotalOrderAmount(transaction));
    }

    public NumberChoice confirmWhichMenuToUseCoupon(Transaction transaction) {
        List<String> literals = new ArrayList<>();
        int index = 0;

        for (Order order : transaction.getOrders()) {
            literals.add(generateCouponUsageLiteral(++index, order));
        }

        outputView.confirmWhichMenuToApplyCoupon(literals);
        return inputView.readNumberChoice();
    }

    private String generateCouponUsageLiteral(int index, Order order) {
        StringBuilder literal = new StringBuilder();
        literal.append(index);
        literal.append(LiteralCollection.BLANK.getLiteral());
        literal.append(order.getMenuName());

        return literal.toString();
    }

    private ConfirmMessage getConfirmMessage() {
        boolean yesOrNot = inputView.readYesOrNot();
        return new ConfirmMessage(yesOrNot);
    }

    private String checkCouponUsage(Order order) {
        if (order.isCouponApplied()) {
            return "(쿠폰사용)";
        }
        return "";
    }

    private Integer computeTotalOrderAmount(Transaction transaction) {
        return transaction.getOrders().stream()
                .map(Order::getOrderAmount)
                .reduce(0, Integer::sum);
    }

    private String generateOrderLiteral(int index, Order order) {
        StringBuilder orderLiteral = new StringBuilder();
        orderLiteral.append(index);
        orderLiteral.append(LiteralCollection.DOT.getLiteral());
        orderLiteral.append(LiteralCollection.BLANK.getLiteral());
        orderLiteral.append(order.getMenuName());
        orderLiteral.append(LiteralCollection.BLANK.getLiteral());
        orderLiteral.append(order.getOrderQuantity());
        orderLiteral.append(LiteralCollection.COUNT.getLiteral());
        orderLiteral.append(LiteralCollection.BLANK.getLiteral());
        orderLiteral.append(order.getOrderAmount());
        orderLiteral.append(LiteralCollection.WON.getLiteral());
        orderLiteral.append(checkCouponUsage(order));

        return orderLiteral.toString();
    }
}
