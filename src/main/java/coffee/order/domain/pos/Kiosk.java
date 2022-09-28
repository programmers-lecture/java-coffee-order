package coffee.order.domain.pos;

import coffee.order.domain.customer.Customer;
import coffee.order.domain.food.Food;
import coffee.order.domain.order.Order;
import coffee.order.domain.order.Orders;

import static coffee.order.domain.customer.Customers.CUSTOMERS_DATA;
import static coffee.order.domain.food.FoodCategory.findFoodsByCategoryId;
import static coffee.order.domain.food.FoodCategory.getMenuMessage;
import static coffee.order.domain.pos.KioskCommand.YES;
import static coffee.order.message.CouponMessage.*;
import static coffee.order.message.InputMessage.INPUT_CUSTOMER_SELECT_MENU;
import static coffee.order.view.OutputView.print;

public class Kiosk {

    public void process(Customer customer) {
        order(customer);
        askSaveCoupon(customer);
        askUseCoupon(customer);
    }

    private void order(Customer customer) {
        print(INPUT_CUSTOMER_SELECT_MENU.message);
        print(getMenuMessage());
        Orders orders = new Orders();
        orders.addOrder(
                createOrder(customer.commands()));
        customer.addMyOrder(orders);
    }

    private Order createOrder(String orderCommand) {
        return new Order(
                findFoodByCategoryIdAndFoodId(
                        findFoodCategoryId(orderCommand),
                        findFoodId(orderCommand)
                ),
                findOrderedFoodQuantity(orderCommand));
    }

    private Food findFoodByCategoryIdAndFoodId(Long foodCategoryId, Long foodId) {
        return findFoodsByCategoryId(foodCategoryId)
                .findFoodByFoodId(foodId);
    }

    private Long findFoodCategoryId(String orderCommand) {
        return Long.parseLong(orderCommand.substring(0, 1));
    }

    private Long findFoodId(String orderCommand) {
        return Long.parseLong(orderCommand.substring(2, 3));
    }

    private int findOrderedFoodQuantity(String orderCommand) {
        return Integer.parseInt(orderCommand.substring(5).trim());
    }

    private boolean checkCustomersCommandYes(String command) {
        return command.equals(YES.selectedCommand);
    }

    private void askSaveCoupon(Customer customer) {
        print(KIOSK_ASK_SAVE_COUPON.message);
        print(KIOSK_SELECT_YES_OR_NO.message);
        if (checkCustomersCommandYes(customer.commands())) {
            askPhoneNumber(customer);
            customer.saveCoupon();
        }
    }

    private void askPhoneNumber(Customer customer) {
        print(KIOSK_ASK_PHONE_NUMBER.message);
        String phoneNumber = customer.commands();
        if (CUSTOMERS_DATA.checkPhoneNumberExists(phoneNumber)) {
            customer = CUSTOMERS_DATA.findCustomerByPhoneNumber(phoneNumber);
        }
        if (!CUSTOMERS_DATA.checkPhoneNumberExists(phoneNumber)) {
            CUSTOMERS_DATA.saveCustomerWithPhoneNumber(customer, phoneNumber);
        }
    }

    private void askUseCoupon(Customer customer) {
        print(KIOSK_ASK_USE_COUPON.message);
        print(KIOSK_SELECT_YES_OR_NO.message);
        if (checkCustomersCommandYes(customer.commands())) {
            customer.useCoupon();
        }
    }

}
