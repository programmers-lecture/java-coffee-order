package coffee.order.domain.kiosk.setting;

import coffee.order.domain.customer.Phone;
import coffee.order.domain.food.FoodCategory;
import coffee.order.view.input.kiosk.barista.form.FoodEnrollForm;
import coffee.order.domain.order.Orders;
import coffee.order.domain.receipt.Receipt;
import coffee.order.view.input.kiosk.barista.form.FoodUpdateForm;

import static coffee.order.domain.kiosk.receipt.KioskReceipts.RECEIPTS;

public class KioskSetting {

    public void reflectReceipt(Phone phone, Receipt receipt) {
        RECEIPTS.saveReceipt(phone, receipt);
    }

    public void reflectOrders(Orders orders) {
        orders.changeFoodQuantityByThisOrders();
    }

    public void reflectNewFood(FoodEnrollForm form) {
        FoodCategory.enrollFood(form);
    }

    public void reflectUpdateFoodQuantity(FoodUpdateForm form) {
        FoodCategory.updateFood(form);
    }
}
