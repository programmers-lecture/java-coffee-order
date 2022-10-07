package coffee.order.service;

import coffee.order.model.MenuType;
import coffee.order.model.Transaction;
import coffee.order.view.Order;

public class ChoiceConverter {
    public Transaction convertToTransaction(Order order, MenuService menuService) {
        MenuType menuType = MenuType.findMenuType(order.getMenuType());
        String menuName = menuService.findMenuName(menuType, order.getMenuName());
        int orderQuantity = order.getOrderQuantity();
        int orderAmount = menuService.findMenuPrice(menuType, menuName);

        return new Transaction(menuType, menuName, orderQuantity);
    }
}
