package coffee.order.view.output.controller;

public enum ControllerMessage {

    CONTROLLER_INPUT_USER_SELECT("\n사용자를 선택하세요\n1. 손님 / 2. 바리스타\n");

    public final String message;

    ControllerMessage(String message) {
        this.message = message;
    }
}
