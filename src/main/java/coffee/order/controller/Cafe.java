package coffee.order.controller;

import coffee.order.domain.meals.*;
import coffee.order.domain.order.Orders;

import java.util.Arrays;
import java.util.List;

public class Cafe {

    private Menus menus;
    private Orders orders;

    public Cafe(){
        this.menus = new Menus();
        this.orders = new Orders();
    }

    public Menus getMenus(){
        return menus;
    }
    public Orders getOrders() {return orders;}

    public void createOrderList(List<String[]> orderMenus) {
        //메뉴들로 오더 리스트를 생성한다.
        for (String[] orderMenu: orderMenus) {
            String serialNumber = orderMenu[0];
            int quantity = Integer.parseInt(orderMenu[1]);
            orders.createOrder(menus.findBySerialNumber(serialNumber),quantity);
        }
    }
}
