package coffee.order.domain.kiosk.barista.factory;

import coffee.order.domain.kiosk.KioskManager;
import coffee.order.domain.kiosk.form.FoodEnrollForm;
import coffee.order.view.input.kiosk.barista.factory.KioskBaristaFoodEnrollManagerInput;
import coffee.order.view.output.kiosk.barista.factory.KioskBaristaFoodEnrollManagerHistoryMessage;

public class KioskBaristaFoodEnrollManager implements KioskBaristaProcess {

    public KioskBaristaFoodEnrollManagerHistoryMessage foodEnrollHistory() {
        return new KioskBaristaFoodEnrollManagerHistoryMessage();
    }

    public KioskBaristaFoodEnrollManagerInput foodEnrollInput() {
        return new KioskBaristaFoodEnrollManagerInput();
    }

    @Override
    public void process(KioskManager kioskManager) {
        foodEnrollHistory().askBaristaToEnrollForm();
        FoodEnrollForm foodEnrollForm = foodEnrollInput().askFoodEnrollForm();
        kioskManager.loadKioskSetting().reflectNewFood(foodEnrollForm);
        foodEnrollHistory().printEnrollFinished();
    }

}
