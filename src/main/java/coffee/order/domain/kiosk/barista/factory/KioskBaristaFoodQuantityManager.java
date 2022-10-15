package coffee.order.domain.kiosk.barista.factory;

import coffee.order.domain.kiosk.KioskManager;
import coffee.order.view.input.kiosk.barista.factory.KioskBaristaFoodQuantityManagerInput;
import coffee.order.view.input.kiosk.barista.form.FoodUpdateForm;
import coffee.order.view.output.kiosk.barista.factory.KioskBaristaFoodQuantityManagerHistoryMessage;

public class KioskBaristaFoodQuantityManager implements KioskBaristaProcess {

    public KioskBaristaFoodQuantityManagerHistoryMessage foodQuantityUpdateHistory() {
        return new KioskBaristaFoodQuantityManagerHistoryMessage();
    }

    public KioskBaristaFoodQuantityManagerInput foodQuantityInput() {
        return new KioskBaristaFoodQuantityManagerInput();
    }

    @Override
    public void process(KioskManager kioskManager) {
        foodQuantityUpdateHistory().askMenuAndFoodQuantity();
        foodQuantityUpdateHistory().printMenus();
        FoodUpdateForm foodQuantityUpdateForm = foodQuantityInput().askMenuAndFoodQuantity();
        kioskManager.loadKioskSetting().reflectUpdateFood(foodQuantityUpdateForm);
        foodQuantityUpdateHistory().printUpdateFinished();
    }
}
