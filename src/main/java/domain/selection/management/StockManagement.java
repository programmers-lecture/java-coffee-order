package domain.selection.management;

import domain.cafe.Cafe;
import io.input.information.SetStockInformation;
import io.input.Input;
import io.output.Output;

public class StockManagement {
    public static void setStock(Cafe cafe) {
        Output.printSetStockMessage();
        cafe.showMenuStock();
        SetStockInformation setStockInformation = Input.getInformationForSetStock();
        cafe.setMenuStock(setStockInformation);
        Output.printSuccessfullySetStockMessage();
    }
}
