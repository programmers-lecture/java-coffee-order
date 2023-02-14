package domain.customer;

import domain.barista.Barista;
import domain.order.Order;
import domain.order.OrderList;
import io.input.Input;
import io.output.Output;
import domain.selection.AdditionalOrderSelection;
import domain.selection.EarnCouponSelection;
import domain.selection.UseCouponSelection;

public class Customer {
    private final Barista barista;
    private final OrderList orderList;

    public Customer(Barista barista) {
        this.barista = barista;
        this.orderList = new OrderList();
    }

    public Order getOrderForApplyCoupon() {
        Output.printChoiceOrderForApplyCouponMessage();
        orderList.showOrderForUseCoupon();
        return Input.getOrderForCoupon(orderList);
    }

    public void order() {
        barista.takeOrder(orderList);
    }

    public void addOrder(Order order) {
        orderList.addOrder(order);
    }

    public boolean wantEarnCoupon() {
        Output.printEarnCouponSelectionRequestMessage();
        EarnCouponSelection earnCouponSelection = Input.getEarnCouponSelection();
        return earnCouponSelection == EarnCouponSelection.YES;
    }

    public boolean wantUseCoupon() {
        Output.printUseCouponSelectionRequestMessage();
        UseCouponSelection useCouponSelection = Input.getApplyCouponSelection();
        return useCouponSelection == UseCouponSelection.YES;
    }

    public boolean wantAdditionalOrder() {
        Output.printAskAdditionalOrderMessage();
        AdditionalOrderSelection additionalOrderSelection = Input.getAdditionalOrderSelection();
        return additionalOrderSelection == AdditionalOrderSelection.YES;
    }

    public OrderList getOrderList() {
        return orderList;
    }
}
