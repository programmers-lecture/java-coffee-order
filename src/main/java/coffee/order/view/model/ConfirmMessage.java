package coffee.order.view.model;

public class ConfirmMessage {
    private final boolean whetherOrNot;

    public ConfirmMessage(boolean whetherOrNot) {
        this.whetherOrNot = whetherOrNot;
    }

    public boolean isCustomerSaidYes() {
        return whetherOrNot;
    }
}
