package coffee.order.controller;

import coffee.order.model.Menu;
import coffee.order.model.MenuType;
import coffee.order.service.ChoiceConverter;
import coffee.order.service.CouponService;
import coffee.order.service.MenuService;
import coffee.order.service.TransactionService;
import coffee.order.view.MenuChoice;

import java.util.ArrayList;
import java.util.HashMap;

public class ServiceManager {
    private final MenuService menuService;
    private final CouponService couponService;
    private final TransactionService transactionService;
    private final ChoiceConverter converter;

    public ServiceManager() {
        menuService = new MenuService();
        couponService = new CouponService();
        transactionService = new TransactionService();
        converter = new ChoiceConverter();
    }

    public void initializeMenu() {
        menuService.initializeMenu();
    }

    public HashMap<MenuType, ArrayList<? super Menu>> getMenu() {
        return menuService.getMenuDatabase();
    }

    public void createNewTransaction(MenuChoice menuChoice) {
        transactionService.createNewTransaction(menuChoice, converter, menuService);
    }
}
