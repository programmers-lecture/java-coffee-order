package coffee.order.controller;

import coffee.order.model.Menu;
import coffee.order.model.MenuType;
import coffee.order.service.CouponService;
import coffee.order.service.MenuService;
import coffee.order.service.TransactionService;

import java.util.ArrayList;
import java.util.HashMap;

public class ServiceManager {
    private final MenuService menuService;
    private final CouponService couponService;
    private final TransactionService transactionService;

    public ServiceManager() {
        menuService = new MenuService();
        couponService = new CouponService();
        transactionService = new TransactionService();
    }

    public void initializeMenu() {
        menuService.initializeMenu();
    }

    public HashMap<MenuType, ArrayList<? super Menu>> getMenu() {
        return menuService.getMenu();
    }
}
