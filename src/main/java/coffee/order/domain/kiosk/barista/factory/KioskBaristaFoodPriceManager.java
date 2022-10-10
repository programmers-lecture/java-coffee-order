package coffee.order.domain.kiosk.barista.factory;

import coffee.order.domain.kiosk.KioskManager;
import coffee.order.view.input.kiosk.barista.factory.KioskBaristaFoodPriceManagerInput;
import coffee.order.view.input.kiosk.barista.form.FoodUpdateForm;
import coffee.order.view.output.kiosk.barista.factory.KioskBaristaFoodPriceManagerHistoryMessage;

public class KioskBaristaFoodPriceManager implements KioskBaristaProcess {

    public KioskBaristaFoodPriceManagerHistoryMessage foodPriceUpdateHistory() {
        return new KioskBaristaFoodPriceManagerHistoryMessage();
    }

    public KioskBaristaFoodPriceManagerInput foodPriceInput() {
        return new KioskBaristaFoodPriceManagerInput();
    }

    @Override
    public void process(KioskManager kioskManager) {
        foodPriceUpdateHistory().askMenuAndFoodPrice();
        foodPriceUpdateHistory().printMenus();
        FoodUpdateForm foodUpdateForm = foodPriceInput().askMenuAndFoodPrice();
        kioskManager.loadKioskSetting().reflectUpdateFood(foodUpdateForm);
        foodPriceUpdateHistory().printUpdateFinished();
    }
}
