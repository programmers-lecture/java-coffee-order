package coffee.order.controller;

import coffee.order.service.CouponService;
import coffee.order.service.MenuService;

public class ServiceManager {
    private final MenuService menuService;
    private final CouponService couponService;

    public ServiceManager() {
        menuService = new MenuService();
        couponService = new CouponService();
    }

    public void initializeMenu() {
        menuService.initializeMenu();
    }
}
