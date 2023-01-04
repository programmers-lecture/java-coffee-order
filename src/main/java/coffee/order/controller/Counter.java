package coffee.order.controller;

import coffee.order.domain.meals.Category;
import coffee.order.domain.meals.Menus;
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


}
