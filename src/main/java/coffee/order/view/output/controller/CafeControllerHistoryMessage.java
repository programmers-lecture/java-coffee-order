package coffee.order.view.output.controller;

import static coffee.order.view.output.OutputView.print;
import static coffee.order.view.output.UnitMessage.ENTER;
import static coffee.order.view.output.controller.ControllerMessage.CONTROLLER_INPUT_USER_SELECT;

public class CafeControllerHistoryMessage {

    public void printWhenAskUserSelect() {
        print(ENTER.unit + CONTROLLER_INPUT_USER_SELECT.message + ENTER.unit);
    }
}
