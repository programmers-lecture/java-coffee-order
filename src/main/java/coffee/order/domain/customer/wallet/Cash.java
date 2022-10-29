package coffee.order.domain.customer.wallet;

public class Cash {

    private int cash;

    public Cash(int cash) {
        this.cash = cash;
    }

    protected int getCash() {
        return cash;
    }

    protected void spend(int money) {
        this.cash -= money;
    }
}
