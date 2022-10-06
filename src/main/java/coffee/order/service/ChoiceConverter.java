package coffee.order.service;

import coffee.order.model.MenuType;
import coffee.order.model.Transaction;
import coffee.order.view.MenuChoice;

public class ChoiceConverter {
    public Transaction convertToTransaction(MenuChoice menuChoice, MenuService menuService) {
        MenuType menuType = MenuType.findMenuType(menuChoice.getMenuType());
        String menuName = menuService.findMenuName(menuType, menuChoice.getMenuName());
        int orderAmount = menuChoice.getOrderAmount();

        return new Transaction(menuType, menuName, orderAmount);
    }
}
