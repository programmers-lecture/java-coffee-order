package coffee.order.view;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Scanner;
import java.util.stream.Collectors;

public class InputView {
    private static final String MENU_CHOICE_DELIMITER = ",";

    private final Scanner scanner;

    public InputView() {
        scanner = new Scanner(System.in);
    }

    public HashMap<String, Integer> readMenuChoice() {
        // TODO: 유저가 그만둘 때까지 계속 입력받기
        String menuChoice = scanner.nextLine();
        return convertToTransactionFormat(menuChoice);
    }

    public HashMap<String, Integer> convertToTransactionFormat(String menuChoice) {
        String[] tokens = menuChoice.split(MENU_CHOICE_DELIMITER);
        ArrayList<String> trimmedTokens = Arrays.stream(tokens)
                .map(String::trim)
                .collect(Collectors.toCollection(ArrayList::new));

        HashMap<String, Integer> transactionFormat = new HashMap<>();
        transactionFormat.put(trimmedTokens.get(0), Integer.valueOf(trimmedTokens.get(1)));
        return transactionFormat;
    }

}
