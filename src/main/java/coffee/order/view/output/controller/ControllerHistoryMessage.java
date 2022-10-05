package coffee.order.view.output.controller;

import static coffee.order.view.output.OutputView.print;
import static coffee.order.view.output.controller.ControllerMessage.CONTROLLER_INPUT_USER_SELECT;

public class ControllerHistoryMessage {

    public void printWhenAskUserSelect() {
        print(CONTROLLER_INPUT_USER_SELECT.message);
    }
}
