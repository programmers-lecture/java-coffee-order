package coffee.order.message;

public enum InputMessage {

    INPUT_USER_SELECT("사용자를 선택하세요\n1. 손님 / 2. 바리스타"),
    INPUT_CUSTOMER_SELECT_MENU("// 손님 선택 \n메뉴를 골라주세요 (번호, 개수)");

    public final String message;

    InputMessage(String message) {
        this.message = message;
    }
}
