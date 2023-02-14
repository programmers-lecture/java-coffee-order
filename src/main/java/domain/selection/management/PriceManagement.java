package domain.selection.management;

import domain.cafe.Cafe;
import io.input.information.ChangePriceInformation;
import io.input.Input;
import io.output.Output;

public class PriceManagement {
    public static void changePrice(Cafe cafe) {
        Output.printChangePriceMessage();
        cafe.showMenuPrice();
        ChangePriceInformation changePriceInformation = Input.getInformationForChangePrice();
        cafe.changeMenuPrice(changePriceInformation);
        Output.printSuccessfullyChangedPriceMessage(changePriceInformation);
    }
}
