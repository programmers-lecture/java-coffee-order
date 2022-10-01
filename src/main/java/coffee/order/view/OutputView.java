package coffee.order.view;

public class OutputView {

    public static final String ORDER_LIST_MSG = "주문 내역은 아래와 같습니다.";
    public static final String QUESTION_COUPON_MSG = "쿠폰을 적립하시겠습니까?";
    public static final String COUPON_MENU = "사용할 메뉴를 골라주세요.";
    public static final String REQUEST_PHONE_NUMBER = "전화번호를 입력해주세요. (형식 : 000-0000-0000)";
    public static final String ASK_USE_COUPON_MSG = "쿠폰을 사용하시겠습니까?";
    public static final String COUPON_SUCCESS_MSG = "사용이 완료되었습니다.";
    public static final String ORDER_FINISH_MSG = "주문 완료가 되었습니다.";
    public static final String REQUEST_ANSWER_MSG = "1. 네 2. 아니요";
    public static final String CURRENT_COUPON_COUNT_MSG = "현재 쿠폰 갯수는 %d개 입니다.\n";
    private final String REQUEST_MENU = "메뉴를 골라주세요 (번호, 갯수) ex) 1-1, 1 ";

    public void printFormat(String format) {
        System.out.println(format);
    }

    public void printMenu(String menus) {
        printFormat(REQUEST_MENU);
        printFormat(menus);
    }

    public void printCartInfo(String menusInfo) {
        printFormat(menusInfo);
    }

    public void printOderList() {
        printFormat(ORDER_LIST_MSG);
    }

    public void printUseCoupon() {
        printFormat(QUESTION_COUPON_MSG);
        printFormat("1. 네 2. 아니요");
    }

    public void printCouponChoiceMenu() {
        printFormat(COUPON_MENU);
    }

    public void requestPhoneNumber() {
        printFormat(REQUEST_PHONE_NUMBER);
    }

    public void printCouponAmount(int amount) {
        System.out.printf(CURRENT_COUPON_COUNT_MSG, amount);
    }

    public void askUseCoupon() {
        printFormat(ASK_USE_COUPON_MSG);
        printFormat(REQUEST_ANSWER_MSG);
    }

    public void printSuccessCouponMSG() {
        printFormat(COUPON_SUCCESS_MSG);
    }

    public void printFinishOrder() {
        printFormat(ORDER_FINISH_MSG);
    }
}
