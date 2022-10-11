package coffee.order.view.output.controller;

import coffee.order.view.output.UnitMessage;

public enum ControllerMessage {

    CONTROLLER_INPUT_USER_SELECT("사용자를 선택하세요" + UnitMessage.ENTER.unit + "1. 손님 / 2. 바리스타");

    public final String message;

    ControllerMessage(String message) {
        this.message = message;
    }
}
