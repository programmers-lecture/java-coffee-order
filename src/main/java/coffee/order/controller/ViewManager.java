package coffee.order.controller;

import coffee.order.model.Menu;
import coffee.order.model.MenuType;
import coffee.order.view.InputView;
import coffee.order.view.MenuChoice;
import coffee.order.view.OutputView;

import java.util.ArrayList;
import java.util.HashMap;

public class ViewManager {
    private final InputView inputView;
    private final OutputView outputView;

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

    public MenuChoice readMenuChoice() {
        return inputView.readMenuChoice();
    }
}
