package domain.selection.management;

import domain.cafe.Cafe;
import io.input.Input;
import io.output.Output;

public class MenuManagement {
    public static void registerMenu(Cafe cafe) {
        Output.printRegisterMenuItemMessage();
        cafe.registerMenuItem(Input.getMenuItem());
        Output.printSuccessfullyRegisteredMessage();
    }
}
