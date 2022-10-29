package coffee.order.view;

import coffee.order.view.model.CustomerOrder;
import coffee.order.view.model.LiteralCollection;
import coffee.order.view.model.NumberChoice;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class InputView {
    private static final String MENU_CHOICE_DELIMITER = ",";
    private static final String MENU_INDEX_DELIMITER = "-";
    private static final String EOF_SYMBOL = "";
    private static final int YES = 1;

    private final Scanner scanner;

    public InputView() {
        scanner = new Scanner(System.in);
    }

    public List<CustomerOrder> readMenuChoice() {
        List<CustomerOrder> customerOrders = new ArrayList<>();
        String menuChoiceLiteral;

        while (!(menuChoiceLiteral = scanner.nextLine()).equals(EOF_SYMBOL)) {
            customerOrders.add(createNewOrder(menuChoiceLiteral));
        }

        return customerOrders;
    }

    public CustomerOrder createNewOrder(String menuChoiceLiteral) {
        String[] tokens = menuChoiceLiteral.split(MENU_CHOICE_DELIMITER);
        ArrayList<String> trimmedTokens = Arrays.stream(tokens)
                .map(String::trim)
                .collect(Collectors.toCollection(ArrayList::new));

        String[] menuIndexInfo = trimmedTokens.get(0).split(LiteralCollection.HYPHEN.getLiteral());

        int menuTypeIndex = Integer.parseInt(menuIndexInfo[0]);
        int menuNameIndex = Integer.parseInt(menuIndexInfo[1]);
        int orderQuantity = Integer.parseInt(trimmedTokens.get(1));

        return new CustomerOrder(menuTypeIndex, menuNameIndex, orderQuantity);
    }

    public boolean readYesOrNot() {
        int userChoice = Integer.parseInt(scanner.nextLine());
        return userChoice == YES;
    }

    public String readPhoneNumber() {
        return scanner.nextLine();
    }

    public NumberChoice readNumberChoice() {
        int choice = Integer.parseInt(scanner.nextLine());
        return new NumberChoice(choice - 1);
    }
}
