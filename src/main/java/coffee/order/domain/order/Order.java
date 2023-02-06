package coffee.order.domain.order;

import coffee.order.domain.meals.Menu;
import coffee.order.domain.meals.Menus;

import java.sql.Array;
import java.util.ArrayList;
import java.util.List;

public class Order {
    private Menu menu;
    private int quantity;

    public Order(Menu menu, int quantity){
        this.menu = menu;
        this.quantity = quantity;
    }

    public String getOrderMenuName(){
        return menu.getMenuName();
    }

    public String getOrderMenuSerialNumber(){
        return menu.getSerialNumber();
    }

    public int getOrderMenuPrice(){
        return menu.getPrice()*quantity;
    }

    public Menu getMenu() {
        return menu;
    }

    public int getQuantity(){
        return quantity;
    }




}
