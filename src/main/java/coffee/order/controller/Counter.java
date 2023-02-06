package coffee.order.controller;

import coffee.order.domain.coupon.Coupon;
import coffee.order.domain.meals.Category;
import coffee.order.domain.meals.Menu;
import coffee.order.domain.meals.Menus;
import coffee.order.domain.order.Orders;
import coffee.order.view.InputView;
import coffee.order.view.OutputView;
import java.util.List;
import java.util.stream.Collectors;

public class Counter {
    public Counter() {}

    public void showMenu(Menus menus) {
        OutputView.printSelectMenu();
        for(Category category : Category.values()){
            OutputView.printMenuCategory(category.getCategoryNumber(),category.getCategory());
            List<String> menuType = getMenuInfo(menus,category);
            OutputView.printMenuType(menuType);
        }
    }

    public List<String> getMenuInfo(Menus menus, Category category) {
        return menus.getMenuByCategory(category)
                .stream()
                .map(menu -> menu.getSerialNumber() + " " + menu.getMenuName() + " " + menu.getPrice())
                .collect(Collectors.toList());
    }

    public List<String[]> takeOrder(){
        return InputView.inputOrder().stream()
                .map(order -> order.split(", "))
                .collect(Collectors.toList());
    }

    public void showOrder(Orders orders) {
        List<String> orderList = orders.getOrders().stream()
                    .map(order -> order.getOrderMenuName() + " " + order.getQuantity() + "개 " + order.getOrderMenuPrice() +"원")
                    .collect(Collectors.toList());
        OutputView.printOrder(orderList);
        OutputView.printOrderTotalPrice(orders.getTotalPrice());
    }

    public String askEarnCoupon(){
        OutputView.printAskEarnCoupon();
        if(InputView.inputYesOrNo()==1){
            OutputView.printAskPhoneNumber();
           return InputView.inputPhoneNumber(); };
        return "";
    }

    public void showCoupon(int userCouponCnt){
        OutputView.printCouponCount(userCouponCnt);
    }

    public int askUseCoupon(){
        OutputView.printAskUseCoupon();
        return InputView.inputYesOrNo();
    }
    // 쿠폰 사용 동의
    public void showOrdersToCouponUse(Orders orders){
        OutputView.printSelectUseCouponMenu();
        List<String> orderList = orders.getOrders().stream()
                .map(order -> order.getOrderMenuSerialNumber() + " " + order.getOrderMenuName())
                .collect(Collectors.toList());
        OutputView.printOrder(orderList);
    }
    //쿠폰을 사용할 메뉴 선택
    public String couponMenu(){
        return InputView.inputCouponMenuSerialNumber();
    }


    // 쿠폰 사용 후의 상태
    public void showCouponUseOrder(Orders orders){
        List<String> modifiedOrderList =  orders.getOrders().stream()
                .map(order -> order.getOrderMenuName() + " 1개 쿠폰 사용")
                .collect(Collectors.toList());
        OutputView.printOrder(modifiedOrderList);
        OutputView.printOrderTotalPrice(orders.getTotalPrice());
    }

    public void endOrder(){
        OutputView.printEndOrder();
    }





}
