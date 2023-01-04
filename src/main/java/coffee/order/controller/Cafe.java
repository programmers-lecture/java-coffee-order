package coffee.order.controller;

import coffee.order.domain.meals.*;

public class Cafe {

    private Menus menus;

    public Cafe(){
        this.menus = new Menus();
    }

    public Menus getMenus(){
        return menus;
    }


}
