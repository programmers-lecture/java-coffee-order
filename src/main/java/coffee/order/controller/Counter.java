package coffee.order.controller;

import coffee.order.domain.meals.Category;
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

    //쿠폰을 적립하는 지

    // yes라고 하면 전화번호를 입력해달라

    //쿠폰의 개수 조회해주기

    //10개인 경우
    // 쿠폰을 사용하시겠스니까 출력

    // 사용할 메뉴 입력






}
