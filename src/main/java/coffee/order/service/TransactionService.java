package coffee.order.service;

import coffee.order.model.MenuType;
import coffee.order.model.Order;
import coffee.order.model.Transaction;
import coffee.order.repository.TransactionRepository;
import coffee.order.view.model.CustomerOrder;

import java.util.ArrayList;
import java.util.List;

public class TransactionService {
    private final TransactionRepository transactionRepository;

    public TransactionService() {
        transactionRepository = new TransactionRepository();
    }

    public Transaction createNewTransaction(List<CustomerOrder> customerOrders, MenuService menuService) {
        Transaction transaction = convertToTransaction(customerOrders, menuService);
        transactionRepository.addTransaction(transaction);

        return transaction;
    }

    private Transaction convertToTransaction(List<CustomerOrder> customerOrders, MenuService menuService) {
        List<Order> orders = new ArrayList<>();

        for (CustomerOrder customerOrder : customerOrders) {
            Order order = convertToOrder(customerOrder, menuService);
            orders.add(order);
        }

        return new Transaction(orders);
    }

    private Order convertToOrder(CustomerOrder customerOrder, MenuService menuService) {
        MenuType menuType = MenuType.findMenuTypeByIndex(customerOrder.getMenuTypeIndex());
        String menuName = menuService.findMenuName(menuType, customerOrder.getMenuNameIndex());
        int orderQuantity = customerOrder.getOrderQuantity();
        int orderAmount = menuService.findMenuPrice(menuType, menuName) * orderQuantity;

        return new Order(menuType, menuName, orderQuantity, orderAmount);
    }
}
