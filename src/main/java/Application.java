import cafe.Cafe;
import io.input.Input;
import io.output.Output;
import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;
import menu.Menu;
import menu.MenuCategory;

public class Application {
    private static final int CUSTOMER = 1;
    private static final int BARISTA = 2;
    private static final String COMMA = ",";
    private static final String HYPHEN = "-";
    private static final String SPACE = " ";
    private static final String DELETE = "";
    private static final int CATEGORY_NUMBER = 0;
    private static final int MENU_NUMBER = 1;
    private static final int STOCK = 2;
    private static final int PRICE = 2;

    public static void main(String[] args) {
        Cafe cafe = new Cafe();
        Menu menu = new Menu();
        menu.init();

        Output.printUserChoiceRequestMessage();
        int userChoice = Input.getChoice();
        if (userChoice == CUSTOMER) {
            return;
        }
        if (userChoice == BARISTA) {
            Output.printBaristaOptions();

            BaristaOption baristaOption = BaristaOption.getBaristaOption(Input.getChoice());
            if (baristaOption == BaristaOption.REGISTER_MENU) {
                Output.printRegisterMenuItemMessage();

                menu.registerMenuItem(Input.getMenuItem());

                Output.printSuccessfullyRegisteredMessage();
            }
            if (baristaOption == BaristaOption.SET_STOCK) {
                Output.printSetStockMessage();
                Output.printMenuItems(menu.getMenuItems());

                String input = Input.getInformationForSetStock();

                List<String> informationForSetStock =
                        Arrays.asList(input.replace(HYPHEN, COMMA)
                                .replace(SPACE, DELETE)
                                .split(COMMA));
                MenuCategory menuCategory = getMenuCategory(informationForSetStock);
                int menuNumber = getMenuNumber(informationForSetStock);
                int stock = getStock(informationForSetStock);

                menu.setStock(menuCategory, menuNumber, stock);

                Output.printSuccessfullySetStockMessage();
            }
            if (baristaOption == BaristaOption.CHANGE_PRICE) {
                Output.printChangePriceMessage();

                String input = Input.getInformationForChangePrice();

                List<String> informationForChangePrice =
                        Arrays.asList(input.replace(HYPHEN, COMMA)
                                .replace(SPACE, DELETE)
                                .split(COMMA));

                MenuCategory menuCategory = getMenuCategory(informationForChangePrice);
                int menuNumber = getMenuNumber(informationForChangePrice);
                BigDecimal price = getPrice(informationForChangePrice);

                menu.changePrice(menuCategory, menuNumber, price);

                Output.printSuccessfullyChangedPriceMessage(menuCategory, menuNumber, price);
            }
            if (baristaOption == BaristaOption.CHECK_ORDER_HISTORY) {
                cafe.checkOrderHistory();
            }
            if (baristaOption == BaristaOption.CHECK_COUPON_HISTORY) {
                cafe.checkCouponHistory();
            }
        }
    }

    private static MenuCategory getMenuCategory(List<String> informationForSetStock) {
        int categoryNumber = Integer.valueOf(informationForSetStock.get(CATEGORY_NUMBER));
        return MenuCategory.getMenuCategory(categoryNumber);
    }

    private static Integer getMenuNumber(List<String> informationForSetStock) {
        return Integer.valueOf(informationForSetStock.get(MENU_NUMBER));
    }

    private static Integer getStock(List<String> informationForSetStock) {
        return Integer.valueOf(informationForSetStock.get(STOCK));
    }

    private static BigDecimal getPrice(List<String> informationForChangePrice) {
        return BigDecimal.valueOf(Integer.valueOf(informationForChangePrice.get(PRICE)));
    }
}
