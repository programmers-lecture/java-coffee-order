package coffee.order.view;

public class ConfirmMessage {
    private final boolean whetherOrNot;

    public ConfirmMessage(boolean whetherOrNot) {
        this.whetherOrNot = whetherOrNot;
    }

    public boolean isCustomerSaidYes() {
        return whetherOrNot;
    }
}
