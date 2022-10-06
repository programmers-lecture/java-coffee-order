package coffee.order.controller;

import coffee.order.view.InputView;
import coffee.order.view.OutputView;

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
}
