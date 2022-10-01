package coffee.order.view;

import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class InputView {

    private static final Scanner scanner = new Scanner(System.in);
    public static final String MENUS_SEPARATOR = ",";

    public static List<String> inputMenu() {
        return Stream.of(getSplit())
                .map(i -> i.strip())
                .collect(Collectors.toList());
    }

    private static String[] getSplit() {
        return getLine().split(MENUS_SEPARATOR);
    }

    public static String getLine() {
        return scanner.nextLine();
    }
}
