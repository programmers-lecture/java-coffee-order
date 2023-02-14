package io.input;

import domain.order.Order;
import domain.order.OrderList;
import domain.coupon.Coupon;
import io.input.information.ChangePriceInformation;
import io.input.information.SetStockInformation;
import java.util.Scanner;
import domain.menu.Menu;
import domain.menu.MenuItem;
import domain.selection.AdditionalOrderSelection;
import domain.selection.UseCouponSelection;
import domain.selection.EarnCouponSelection;
import domain.selection.BaristaSelection;
import domain.selection.UserSelection;

public class Input {
    private static final InputDataManagement inputDataManager = new InputDataManagement();
    private Input() {
    }

    public static UserSelection getUserSelection() {
        Scanner kb = new Scanner(System.in);
        return inputDataManager.intToUserSelection(kb.nextInt());
    }

    public static BaristaSelection getBaristaSelection() {
        Scanner kb = new Scanner(System.in);
        return inputDataManager.intToBaristaSelection(kb.nextInt());
    }

    public static MenuItem getMenuItem() {
        Scanner kb = new Scanner(System.in);
        return inputDataManager.stringToMenuItem(kb.nextLine());
    }

    public static SetStockInformation getInformationForSetStock() {
        Scanner kb = new Scanner(System.in);
        return inputDataManager.getInformationForSetStock(kb.nextLine());
    }

    public static ChangePriceInformation getInformationForChangePrice() {
        Scanner kb = new Scanner(System.in);
        return inputDataManager.getInformationForChangePrice(kb.nextLine());
    }

    public static Order getOrder(Menu menu) {
        Scanner kb = new Scanner(System.in);
        return inputDataManager.getOrder(kb.nextLine(), menu);
    }

    public static EarnCouponSelection getEarnCouponSelection() {
        Scanner kb = new Scanner(System.in);
        return EarnCouponSelection.getEarnCouponSelection(kb.nextInt());
    }

    public static Coupon getCoupon() {
        Scanner kb = new Scanner(System.in);
        String phoneNumber = kb.nextLine();
        return new Coupon(phoneNumber);
    }

    public static UseCouponSelection getApplyCouponSelection() {
        Scanner kb = new Scanner(System.in);
        return UseCouponSelection.getApplyCouponSelection(kb.nextInt());
    }

    public static Order getOrderForCoupon(OrderList orderList) {
        Scanner kb = new Scanner(System.in);
        return inputDataManager.getOrderForCoupon(kb.nextLine(), orderList);
    }

    public static AdditionalOrderSelection getAdditionalOrderSelection() {
        Scanner kb = new Scanner(System.in);
        return AdditionalOrderSelection.getAdditionalOrder(kb.nextInt());
    }
}
