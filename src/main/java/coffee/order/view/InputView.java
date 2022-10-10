package coffee.order.view;

import coffee.order.view.model.Order;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class InputView {
    private static final String MENU_CHOICE_DELIMITER = ",";
    private static final String MENU_INDEX_DELIMITER = "-";
    private static final String EOF_SYMBOL = "";
    private static final int MENU_NUMBER_INDEX = 0;
    private static final int ORDER_AMOUNT_INDEX = 1;
    private static final int MENU_TYPE_INDEX = 0;
    private static final int MENU_SUB_NUMBER_INDEX = 1;
    private static final int YES = 1;

    private final Scanner scanner;

    public InputView() {
        scanner = new Scanner(System.in);
    }

    public Order readMenuChoice() {
        List<Order> choices = new ArrayList<>();
        String menuChoice;

        while (!(menuChoice = scanner.nextLine()).equals(EOF_SYMBOL)) {
            choices.add(createNewMenuChoice(menuChoice));
        }

        System.out.println(choices);
        return createNewMenuChoice(menuChoice);
    }

    public Order createNewMenuChoice(String menuChoice) {
        String[] tokens = menuChoice.split(MENU_CHOICE_DELIMITER);
        ArrayList<String> trimmedTokens = Arrays.stream(tokens)
                .map(String::trim)
                .collect(Collectors.toCollection(ArrayList::new));

        String menuNumber = trimmedTokens.get(MENU_NUMBER_INDEX);
        String[] menuIndexes = menuNumber.split(MENU_INDEX_DELIMITER);

        int menuType = Integer.parseInt(menuIndexes[MENU_TYPE_INDEX]);
        int menuName = Integer.parseInt(menuIndexes[MENU_SUB_NUMBER_INDEX]);
        int orderQuantity = Integer.parseInt(trimmedTokens.get(ORDER_AMOUNT_INDEX));

        return new Order(menuType, menuName, orderQuantity);
    }

    public boolean readYesOrNot() {
        int userChoice = Integer.parseInt(scanner.nextLine());
        return userChoice == YES;
    }

    public String readPhoneNumber() {
        return scanner.nextLine();
    }
}
